package org.cgic.gateway;

import org.cgic.gateway.annotation.EnableCgicGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@EnableCgicGateway
//@EnableZuulProxy
//@ComponentScan({"org.cgic.gateway.config"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class CgicGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgicGatewayApplication.class, args);
    }

}
