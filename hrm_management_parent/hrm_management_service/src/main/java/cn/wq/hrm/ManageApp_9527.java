package cn.wq.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.wq.hrm.mapper")
public class ManageApp_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ManageApp_9527.class);
    }
}
