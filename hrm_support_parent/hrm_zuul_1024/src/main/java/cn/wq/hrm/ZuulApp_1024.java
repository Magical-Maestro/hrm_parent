package cn.wq.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 注解@EnableZuulProxy过滤器
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApp_1024 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp_1024.class);
    }
}
