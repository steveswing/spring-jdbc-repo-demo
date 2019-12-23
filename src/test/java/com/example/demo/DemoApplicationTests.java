package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.config.H2TestProfileJPAConfig;
import com.example.demo.config.TestEmailConfig;

@SpringBootTest(classes = {TestEmailConfig.class, H2TestProfileJPAConfig.class, DemoApplication.class})
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
}
