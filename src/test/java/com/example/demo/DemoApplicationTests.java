package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.config.H2TestProfileJdbcConfig;
import com.example.demo.config.TestEmailConfig;

@SpringBootTest(classes = {TestEmailConfig.class, H2TestProfileJdbcConfig.class, DemoApplication.class})
public class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
}
