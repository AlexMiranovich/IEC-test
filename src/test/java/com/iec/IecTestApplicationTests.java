package com.iec;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IecTestApplicationTests {

	@Test
	void contextLoads() {
		
		LocalDate date = LocalDate.now();
		System.out.println(date);
	}

}
