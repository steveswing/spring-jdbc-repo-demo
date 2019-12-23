package com.example.demo.controller;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.VoucherRepository;
import com.example.demo.domain.Voucher;
import com.example.demo.domain.VoucherRequestModel;
import com.example.demo.util.CsvWriter;
import com.example.demo.util.EmailService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/voucher", produces = "application/json")
@CrossOrigin(origins = "*")
public class VoucherController {

    private final VoucherRepository voucherRepository;

    public VoucherController(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @Autowired
    private EmailService emailService;

    @GetMapping("/all-paid")
    public Iterable<Voucher> allPaidVouchers() {
        return voucherRepository.findAllPaid();
    }

    @GetMapping("/all-unpaid")
    public Iterable<Voucher> allUnpaidVouchers() {
        return voucherRepository.findAllUnpaid();
    }


    @PostMapping("/request-vouchers")
    @ResponseBody
    public ResponseEntity<String> requestMultipleVoucherInfoAndSendEmail(@RequestBody VoucherRequestModel request) {

        try {
            log.info("Gathering Multiple Voucher Information");

            List<Voucher> vouchers = voucherRepository.findAllUnpaid().stream().filter(request::matches).collect(Collectors.toList());

            CsvWriter csvWriter = new CsvWriter();
            Path attachment = csvWriter.writeDataToCsv(vouchers);
            final String messageRecipient = vouchers.stream().findFirst().map(Voucher::getOrigin).orElseThrow(() -> new RuntimeException("No suitable email address found"));
            log.info("Sending Email Attachment To User");

            emailService.sendSimpleMessage(messageRecipient, attachment);

            log.info("Voucher info valid");
            return new ResponseEntity<>("Voucher information sent to address on file", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.info("Voucher info invalid");
            return new ResponseEntity<>("Voucher Info Incorrect", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
