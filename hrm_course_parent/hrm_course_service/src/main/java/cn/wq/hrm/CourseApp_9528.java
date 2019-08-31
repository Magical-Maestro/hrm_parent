package cn.wq.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.wq.hrm.mapper")
public class CourseApp_9528 {
    public static void main(String[] args) {
        SpringApplication.run(CourseApp_9528.class);
    }
}
