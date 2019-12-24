package com.example.demo.data;

import java.util.List;

import com.example.demo.DemoApplication;
import com.example.demo.config.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.*;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import com.example.demo.domain.Voucher;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest()
@Import({H2TestProfileJPAConfig.class, PersistenceConfig.class})
class VoucherRepositoryTest {

    @Autowired
    VoucherRepository subject;

    /*
    @BeforeAll
    static void init() {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.example.demo");
        ctx.refresh();
    }
     */

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllUnpaid() {
        assertNotNull(subject, "expected non-null subject");

        final List<Voucher> allUnpaid = subject.findAllUnpaid();
        assertNotNull(allUnpaid, "expected non-null value");
    }

    @Test
    void findAllPaid() {
        assertNotNull(subject, "expected non-null subject");

        final List<Voucher> allPaid = subject.findAllPaid();
        assertNotNull(allPaid, "expected non-null value");
    }
}
