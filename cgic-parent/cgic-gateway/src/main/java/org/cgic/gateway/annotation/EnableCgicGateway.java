package org.cgic.gateway.annotation;

import org.cgic.gateway.config.GatewayAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description  自定义网关注解
 * @Author: charleyZZZZ
 * @Date: 2019/10/12 9:41
 * @Version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({GatewayAutoConfiguration.class})
public @interface EnableCgicGateway {
}
