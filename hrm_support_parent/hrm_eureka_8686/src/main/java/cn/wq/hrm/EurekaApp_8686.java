package cn.wq.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApp_8686 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp_8686.class);
    }
}
