package com.patjavahere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringBootAppAOP {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppAOP.class);
	}
}
