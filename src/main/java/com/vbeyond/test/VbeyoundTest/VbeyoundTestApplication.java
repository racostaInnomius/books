package com.vbeyond.test.VbeyoundTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaAuditing
@EnableJpaRepositories("com.vbeyond.test.repository")
@EntityScan(basePackages 	= { "com.vbeyond.test.entities" })
@ComponentScan(basePackages = { "com.vbeyond.test.controller", 
								"com.vbeyond.test.exception" })
public class VbeyoundTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(VbeyoundTestApplication.class, args);
	}

}
