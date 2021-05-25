package com.AkobotWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 어노테이션들을 모두 활성화 할 수 있도록 하는 어노테이션
@SpringBootApplication
public class AkobotWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkobotWebApplication.class, args);
	}

}
