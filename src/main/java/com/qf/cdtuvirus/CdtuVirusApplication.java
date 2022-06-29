package com.qf.cdtuvirus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.qf.cdtuvirus.dao")
@SpringBootApplication
public class CdtuVirusApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdtuVirusApplication.class, args);
    }

}
