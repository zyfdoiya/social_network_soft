package com.csi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 16:26
 * @Version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.csi.database.mapper")
public class StartUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartUpApplication.class,args);
    }
}
