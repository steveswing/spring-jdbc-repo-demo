package com.example.demo.domain;

import java.sql.Timestamp;
import java.util.Currency;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Id
    @Column(name = "VOUCHER_ID")
    String voucherId;

    @Column(name = "BUSINESS_UNIT")
    String businessUnit;
    @Column(name = "INVOICE_ID")
    String invoiceId;
    @Column(name = "INVOICE_DT")
    Date invoiceDate;
    @Column(name = "GROSS_AMT")
    Currency grossAmt;
    @Column(name = "REMIT_VENDOR")
    String remitVendor;
    @Column(name = "NAME1")
    String vendorName;
    @Column(name = "SCHEDULED_PAY_DT")
    Date scheduledPayDt;
    @Column(name = "REMIT_ADDR_SEQ_NUM")
    int remitAddrSeqNbr;
    @Column(name = "PYMNT_METHOD")
    String paymentMethod;
    @Column(name = "PYMNT_HOLD")
    String paymentHold;
    @Column(name = "ORIGIN")
    String origin;
    @Column(name = "POST_STATUS_AP")
    String postStatusAp;
    @Column(name = "PROCESS_MAN_CLOSE")
    String processManClose;
    @Column(name = "DUE_DT")
    Date dueDt;
    @Column(name = "DSCNT_DUE_DT")
    Date discountDueDate;
    @Column(name = "ENTERED_DT")
    Date enteredDate;
    @Column(name = "LAST_UPDATE_DT")
    Date lastUpdateDate;
    @Column(name = "APPR_STATUS")
    String approvalStatus;
    @Column(name = "OPRID_LAST_UPDT")
    Timestamp opridLastUpdate;
    @Column(name = "VOUCHER_TYPE")
    String voucherType;
    @Column(name = "Z_PRE_MATCH_FLAG")
    String zPreMatchFlag;
    @Column(name = "VENDOR_CLASS")
    String vendorClass;
    @Column(name = "VOUCHER_STYLE")
    String voucherStyle;
    @Column(name = "Z_WF_EAPVL_SENT")
    String zWf_EAPVLSent;
    @Column(name = "Z_WF_APV_SENT_DT")
    String zWfApprovalSentDate;
    @Column(name = "SHIPTO_ID")
    String shipYoId;
    @Column(name = "ERROR_FLAG")
    String errorFlag;
    @Column(name = "PYMNT_HOLD_REASON")
    String paymentHoldReason;
    @Column(name = "Z_WF_APRVL_TYPE")
    String zWfApprovalType;
    @Column(name = "VCHR_SRC")
    String voucherSource;
    @Column(name = "MATCH_ACTION")
    String matchAction;
    @Column(name = "MATCH_STATUS_VCHR")
    String matchStatusVoucher;
    @Column(name = "DESCR254_MIXED")
    String description;
    @Column(name = "ENTRY_STATUS")
    String entryStatus;

    public String toCsvString() {
        return "";
    }
}
