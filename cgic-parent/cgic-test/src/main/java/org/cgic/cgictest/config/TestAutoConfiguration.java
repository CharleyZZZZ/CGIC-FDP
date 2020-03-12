package org.cgic.cgictest.config;

import org.bouncycastle.crypto.Signer;
import org.cgic.commons.config.CgicCommonsProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/10/21 16:56
 * @Version 1.0
 */
@EnableEurekaClient
@ComponentScan({"org.cgic.commons.config"})
public class TestAutoConfiguration {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
