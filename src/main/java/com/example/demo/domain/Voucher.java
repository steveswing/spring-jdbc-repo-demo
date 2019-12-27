package com.example.demo.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AccessType(Type.PROPERTY)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table
public class Voucher {
    @Id
    @Column("VOUCHER_ID")
    String voucherId;
    @Column("BUSINESS_UNIT")
    String businessUnit;
    @Column("INVOICE_ID")
    String invoiceId;
    @Column("INVOICE_DT")
    Date invoiceDate;
    @Column("GROSS_AMT")
    BigDecimal grossAmt;
    @Column("REMIT_VENDOR")
    String remitVendor;
    @Column("NAME1")
    String vendorName;
    @Column("SCHEDULED_PAY_DT")
    Date scheduledPayDt;
    @Column("REMIT_ADDR_SEQ_NUM")
    int remitAddrSeqNbr;
    @Column("PYMNT_METHOD")
    String paymentMethod;
    @Column("PYMNT_HOLD")
    String paymentHold;
    @Column("ORIGIN")
    String origin;
    @Column("POST_STATUS_AP")
    String postStatusAp;
    @Column("PROCESS_MAN_CLOSE")
    String processManClose;
    @Column("DUE_DT")
    Date dueDt;
    @Column("DSCNT_DUE_DT")
    Date discountDueDate;
    @Column("ENTERED_DT")
    Date enteredDate;
    @Column("LAST_UPDATE_DT")
    Date lastUpdateDate;
    @Column("APPR_STATUS")
    String approvalStatus;
    @Column("OPRID_LAST_UPDT")
    Timestamp opridLastUpdate;
    @Column("VOUCHER_TYPE")
    String voucherType;
    @Column("Z_PRE_MATCH_FLAG")
    String zPreMatchFlag;
    @Column("VENDOR_CLASS")
    String vendorClass;
    @Column("VOUCHER_STYLE")
    String voucherStyle;
    @Column("Z_WF_EAPVL_SENT")
    String zWf_EAPVLSent;
    @Column("Z_WF_APV_SENT_DT")
    Date zwfapprovalsentdate;
    @Column("SHIPTO_ID")
    String shipYoId;
    @Column("ERROR_FLAG")
    String errorFlag;
    @Column("PYMNT_HOLD_REASON")
    String paymentHoldReason;
    @Column("Z_WF_APRVL_TYPE")
    String zwfapprovaltype;
    @Column("VCHR_SRC")
    String voucherSource;
    @Column("MATCH_ACTION")
    String matchAction;
    @Column("MATCH_STATUS_VCHR")
    String matchStatusVoucher;
    @Column("DESCR254_MIXED")
    String description;
    @Column("ENTRY_STATUS")
    String entryStatus;

    public String toCsvString() {
        return "";
    }
}
