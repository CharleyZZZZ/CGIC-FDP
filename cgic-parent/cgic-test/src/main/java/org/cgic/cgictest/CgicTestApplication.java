package org.cgic.cgictest;

import org.cgic.cgictest.annotation.EnabledCgicTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@EnabledCgicTest
@SpringBootApplication
public class CgicTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgicTestApplication.class, args);
	}

}
