package org.cgic.platform.annotation;

import org.cgic.platform.config.PlatformAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description 自定义CGIC-platform注解
 * @Author: charleyZZZZ
 * @Date: 2019/11/6 16:11
 * @Version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({PlatformAutoConfiguration.class})
public @interface EnabledCgicPlatform {
}
