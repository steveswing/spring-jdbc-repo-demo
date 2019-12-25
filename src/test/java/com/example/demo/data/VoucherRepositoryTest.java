package com.example.demo.data;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import com.example.demo.config.H2TestProfileJdbcConfig;
import com.example.demo.config.TestEmailConfig;
import com.example.demo.domain.Voucher;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@JdbcTest
@EnableJdbcRepositories
@ComponentScan(basePackages = {"com.example.demo"}, basePackageClasses = {TestEmailConfig.class, H2TestProfileJdbcConfig.class})
class VoucherRepositoryTest {

    @Qualifier("voucherRepository")
    @Autowired
    VoucherRepository subject;

    @BeforeAll
    static void init() {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.example.demo");
        ctx.refresh();
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllUnpaid() {
        assertNotNull(subject, "expected non-null subject");

        final List<Voucher> allUnpaid = subject.fetchUnpaid();
        assertNotNull(allUnpaid, "expected non-null value");
    }

    @Test
    void findAllPaid() {
        assertNotNull(subject, "expected non-null subject");

        final List<Voucher> allPaid = subject.fetchPaid();
        assertNotNull(allPaid, "expected non-null value");
    }
}
