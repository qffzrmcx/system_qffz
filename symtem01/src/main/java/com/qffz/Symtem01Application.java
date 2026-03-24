package com.qffz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Symtem01Application {

    public static void main(String[] args) {
        SpringApplication.run(Symtem01Application.class, args);
    }

}
