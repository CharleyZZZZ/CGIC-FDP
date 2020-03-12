package org.cgic.oauth.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Description  CGIC-oauth 自动配置类
 * @Author: charleyZZZZ
 * @Date: 2019/11/6 15:22
 * @Version 1.0
 */
@EnableEurekaClient
@EnableResourceServer
@ComponentScan({"org.cgic.oauth.config",
        "org.cgic.commons.config"})
public class OauthAutoConfiguration {

    public OauthAutoConfiguration() {
    }

    /*这里可以写一些@bean**/
}
