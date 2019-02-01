package com.snail.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.snail.wms.dao")
public class SnailWmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnailWmsApplication.class, args);
    }

}

