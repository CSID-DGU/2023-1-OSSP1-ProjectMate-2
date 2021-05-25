package com.AkobotWeb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class AkobotWebApplicationTests {

	@Test
	void contextLoads() {
	}

	/* JPA Auditing 테스트 코드 */
	@Test
	public void baseTimeEntity_test(){
		//given
		LocalDateTime now = LocalDateTime.of(2021,05,25,0,0,0);
	}

}
