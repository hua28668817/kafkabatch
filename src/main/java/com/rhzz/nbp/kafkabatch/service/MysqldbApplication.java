package com.rhzz.nbp.kafkabatch.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;


public class MysqldbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MysqldbApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

       // JSON.DEFFAULT_DATE_FORMAT= Contants.DateTimeFormat.DATE_TIME_PATTERN;
    }

}
