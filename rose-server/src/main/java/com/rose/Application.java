package com.rose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开启服务注册中心
 */
@EnableEurekaServer
@SpringBootApplication
@RestController
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class,args);

    }
    @RequestMapping("/server")
    public String get(){
        return "hello server";
    }
}
