package com.slk.mallprojectvue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.slk.mallprojectvue.mapper")
public class MallprojectvueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallprojectvueApplication.class, args);
    }

}
