package com.example.demo;

import com.example.demo.config.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TestEmailConfig.class, H2TestProfileJPAConfig.class, DemoApplication.class})
public class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
