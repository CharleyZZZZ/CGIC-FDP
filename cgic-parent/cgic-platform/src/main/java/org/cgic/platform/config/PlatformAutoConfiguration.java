package org.cgic.platform.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/11/6 16:13
 * @Version 1.0
 */
@EnableEurekaClient
@ComponentScan({"org.cgic.commons.config"})
public class PlatformAutoConfiguration {

    public PlatformAutoConfiguration() {
    }


}
