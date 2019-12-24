package com.example.demo.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Data
@RequiredArgsConstructor
public class VoucherRequestModel {
    public boolean matches(final Voucher voucher) {
        return false;
    }
}
