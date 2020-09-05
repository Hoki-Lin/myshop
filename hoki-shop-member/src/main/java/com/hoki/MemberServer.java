package com.hoki;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName:MemberServer
 * Package:com.hoki
 * Description:
 *
 * @author :Hoki_Lin
 * @date :2020/9/1 11:12
 */
@SpringBootApplication
@EnableEurekaClient
//@MapperScan({"com.hoki"})
public class MemberServer {
    public static void main(String[] args) {
        SpringApplication.run(MemberServer.class, args);
    }
}
