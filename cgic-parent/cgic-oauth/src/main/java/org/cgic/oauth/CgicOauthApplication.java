package org.cgic.oauth;

import org.cgic.oauth.annotation.EnabledCgicOauth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnabledCgicOauth
public class CgicOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgicOauthApplication.class, args);
    }

}
