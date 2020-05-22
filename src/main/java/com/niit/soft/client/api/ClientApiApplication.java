package com.niit.soft.client.api;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

//@EnableRabbit //开启基于注解的RabbitMQ模式
//@ComponentScan(basePackages = {"com.niit.soft.client.api"})
//@EnableScheduling   //开启定时
//@EnableAsync  //作用于启动类，放置在启动类上开启异步任务注解
@SpringBootApplication
public class ClientApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApiApplication.class, args);
    }

}
