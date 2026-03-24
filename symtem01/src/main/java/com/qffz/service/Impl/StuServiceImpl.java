package com.qffz.service.Impl;

import com.qffz.mapper.StuMapper;
import com.qffz.mapper.StuUploadMapper;
import com.qffz.pojo.*;
import com.qffz.service.StuLogService;
import com.qffz.service.StuService;
import com.qffz.utils.JwtUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;
    @Autowired
    private StuUploadMapper stuUploadMapper;
    @Autowired
    private StuLogService stuLogService;
    @Override
    public PageResult<Student> page(StuQueryParam stuQueryParam){
        PageHelper.startPage(stuQueryParam.getPage(),stuQueryParam.getPagesize());
        List<Student> stulist =stuMapper.list(stuQueryParam);
        Page<Student> p = (Page<Student>)stulist;
        return new PageResult<Student>(p.getTotal(),p.getResult());
    }
    @Transactional
    @Override
    public void deleteByIds(List<Integer> ids) {

        stuMapper.deleteByIds(ids);

        stuUploadMapper.deleteByStuIds(ids);
    }
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void add(Student student){
        if(student.getGender()==null)
            student.setGender("2");
        try{
        student.setEnterTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        stuMapper.add(student);

        Integer stuId = student.getId();
        List<StuUpload> uploadList = student.getUploadList();
        if(!CollectionUtils.isEmpty(uploadList)){
            uploadList.forEach(stuUpload -> stuUpload.setStuId(stuId));
            stuUploadMapper.addBatch(uploadList);
        }
    } finally {
        //记录操作日志
        StuLog stuLog = new StuLog(null, LocalDateTime.now(), student.toString());
        stuLogService.insertLog(stuLog);
    }

}
    @Override
    public Student getById(Integer id){
        return stuMapper.getById(id);
    }

    @Transactional
    @Override
    public void update(Student student) {
        //1. 根据ID更新学生基本信息
        student.setUpdateTime(LocalDateTime.now());
        stuMapper.updateById(student);

        //2. 根据学生ID删除学生的博客上传信息
        stuUploadMapper.deleteByStuIds(Arrays.asList(student.getId()));

        //3. 新增学生的博客上传数据
        Integer stuId = student.getId();
        List<StuUpload> exprList = student.getUploadList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> empExpr.setStuId(stuId));
            stuUploadMapper.addBatch(exprList);
        }
    }

        @Override
        public Result login(Student student) {
            Student stuLogin1 = stuMapper.getStunum(student);
            Student stuLogin2 = stuMapper.getPassword(student);
            if(stuLogin1 != null && stuLogin2 != null){
                Map<String,Object> dataMap = new HashMap<>();
                dataMap.put("id", stuLogin1.getId());
                dataMap.put("stunum", stuLogin1.getStunum());

                String jwt = JwtUtil.generateJwt(dataMap);
                Login login1 = new Login(stuLogin1.getId(), stuLogin1.getStunum(), stuLogin1.getName(), jwt);
                return Result.success(login1);
            } else if (stuLogin1==null && stuLogin2==null) {
                return Result.error("笨笨user,一个都记不住~");
            } else if (stuLogin1 == null){
                return Result.error("用户名错误~");
            }else if (stuLogin2 == null){
                return Result.error("密码错误~");
            }
            return null;
        }
    }

