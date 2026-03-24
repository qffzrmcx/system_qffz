package com.qffz.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import jakarta.servlet.Filter;

@WebFilter("/*")
@Slf4j
public class QffzFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器启动了...");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到了");
    //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {
        log.info("过滤器销毁了...");
    }
}
