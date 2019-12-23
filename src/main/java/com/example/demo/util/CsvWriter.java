package com.example.demo.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.domain.Voucher;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvWriter {

    public Path writeDataToCsv(Voucher voucher) throws IOException {
        final String companyName = voucher.getVendorName();

        try {
            final Path result = Files.createTempFile(String.format("%s_", companyName.replaceAll("[^\\x00-\\x20A-Za-z0-9-!@#$%^()&]", "")), ".csv");
            try (final Writer writer = new FileWriter(result.toFile())) {
                CsvUtils.writeLine(writer, Arrays.asList("VendorID", "InvoiceID", "InvoiceAmt", "PaymentStatus"));
                List<String> columns = Arrays.asList(voucher.getVendorName(), voucher.getInvoiceId(), voucher.getGrossAmt().toString(), voucher.getDueDt().toString());
                CsvUtils.writeLine(writer, columns);
            }
            return result;
        } catch (IOException e) {
            log.error(String.format("Failed writing Invoice: %s", voucher), e);
            throw e;
        }
    }

    public Path writeDataToCsv(final List<Voucher> vouchers) throws IOException {
        final String companyName = vouchers.stream().findFirst().map(Voucher::getVendorName).orElse("vendor-undefined");
        try {
            final Path result = Files.createTempFile(String.format("%s_", companyName.replaceAll("[^\\x00-\\x20A-Za-z0-9!@#$%^()&]", "")), ".csv");
            try (final Writer writer = new FileWriter(result.toFile())) {
                Files.write(result,
                        Stream.concat(Stream.of(String.join(",", "VendorID", "InvoiceID", "InvoiceAmt", "PaymentStatus")), vouchers.stream().map(Voucher::toCsvString)).collect(Collectors.toList()));
                return result;
            }
        } catch (final IOException e) {
            log.error(String.format("Failed writing Vouchers: %s", vouchers), e);
            throw e;
        }
    }

    public void removeFile(final Path file) throws IOException {
        if (Files.deleteIfExists(file)) {
            log.debug(String.format("%s successfully deleted", file));
        } else {
            log.warn(String.format("%s not found to delete", file));
        }
    }
}
