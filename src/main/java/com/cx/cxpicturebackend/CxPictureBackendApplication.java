package com.cx.cxpicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.cx.cxpicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class CxPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CxPictureBackendApplication.class, args);
    }

}
