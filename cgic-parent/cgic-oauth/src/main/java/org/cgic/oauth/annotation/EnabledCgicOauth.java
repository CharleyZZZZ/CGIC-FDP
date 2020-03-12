package org.cgic.oauth.annotation;

import org.cgic.oauth.config.OauthAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/11/6 15:21
 * @Version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({OauthAutoConfiguration.class})
public @interface EnabledCgicOauth {
}
