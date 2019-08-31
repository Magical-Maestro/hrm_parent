package cn.wq.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 注解:@EnableEurekaClient:加入注册中心
 * 注解:@EnableConfigServer:启用配置服务端
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApp_2048 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApp_2048.class);
    }
}
