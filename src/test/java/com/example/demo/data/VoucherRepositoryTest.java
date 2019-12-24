package com.example.demo.data;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.example.demo.config.H2TestProfileJdbcConfig;
import com.example.demo.config.PersistenceConfig;
import com.example.demo.domain.Voucher;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Import({H2TestProfileJdbcConfig.class, PersistenceConfig.class})
class VoucherRepositoryTest {

    @Autowired
    VoucherRepository subject;

    @BeforeEach
    void setUp() {
    }

    @Test
    void fetchUnpaid() {
        assertNotNull(subject, "expected non-null subject");

        final List<Voucher> allUnpaid = subject.fetchUnpaid();
        assertNotNull(allUnpaid, "expected non-null value");
    }

    @Test
    void fetchPaid() {
        assertNotNull(subject, "expected non-null subject");

        final List<Voucher> allPaid = subject.fetchPaid();
        assertNotNull(allPaid, "expected non-null value");
    }
}
