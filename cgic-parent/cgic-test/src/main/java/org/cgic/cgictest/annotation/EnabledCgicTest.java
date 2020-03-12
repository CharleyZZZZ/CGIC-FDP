package org.cgic.cgictest.annotation;

import org.cgic.cgictest.config.TestAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description
 * @Author: charleyZZZZ
 * @Date: 2019/10/21 16:55
 * @Version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({TestAutoConfiguration.class})
public @interface EnabledCgicTest {
}
