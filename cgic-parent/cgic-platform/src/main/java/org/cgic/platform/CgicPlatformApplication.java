package org.cgic.platform;

import org.cgic.platform.annotation.EnabledCgicPlatform;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnabledCgicPlatform
@SpringBootApplication
public class CgicPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgicPlatformApplication.class, args);
	}

}
