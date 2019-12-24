package com.example.demo.domain;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.relational.core.mapping.*;

import java.sql.Timestamp;
import java.util.*;

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
    Currency grossAmt;
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
    String zWfApprovalSentDate;
    @Column("SHIPTO_ID")
    String shipYoId;
    @Column("ERROR_FLAG")
    String errorFlag;
    @Column("PYMNT_HOLD_REASON")
    String paymentHoldReason;
    @Column("Z_WF_APRVL_TYPE")
    String zWfApprovalType;
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

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Currency getGrossAmt() {
        return grossAmt;
    }

    public void setGrossAmt(Currency grossAmt) {
        this.grossAmt = grossAmt;
    }

    public String getRemitVendor() {
        return remitVendor;
    }

    public void setRemitVendor(String remitVendor) {
        this.remitVendor = remitVendor;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Date getScheduledPayDt() {
        return scheduledPayDt;
    }

    public void setScheduledPayDt(Date scheduledPayDt) {
        this.scheduledPayDt = scheduledPayDt;
    }

    public int getRemitAddrSeqNbr() {
        return remitAddrSeqNbr;
    }

    public void setRemitAddrSeqNbr(int remitAddrSeqNbr) {
        this.remitAddrSeqNbr = remitAddrSeqNbr;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentHold() {
        return paymentHold;
    }

    public void setPaymentHold(String paymentHold) {
        this.paymentHold = paymentHold;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPostStatusAp() {
        return postStatusAp;
    }

    public void setPostStatusAp(String postStatusAp) {
        this.postStatusAp = postStatusAp;
    }

    public String getProcessManClose() {
        return processManClose;
    }

    public void setProcessManClose(String processManClose) {
        this.processManClose = processManClose;
    }

    public Date getDueDt() {
        return dueDt;
    }

    public void setDueDt(Date dueDt) {
        this.dueDt = dueDt;
    }

    public Date getDiscountDueDate() {
        return discountDueDate;
    }

    public void setDiscountDueDate(Date discountDueDate) {
        this.discountDueDate = discountDueDate;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Timestamp getOpridLastUpdate() {
        return opridLastUpdate;
    }

    public void setOpridLastUpdate(Timestamp opridLastUpdate) {
        this.opridLastUpdate = opridLastUpdate;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public String getzPreMatchFlag() {
        return zPreMatchFlag;
    }

    public void setzPreMatchFlag(String zPreMatchFlag) {
        this.zPreMatchFlag = zPreMatchFlag;
    }

    public String getVendorClass() {
        return vendorClass;
    }

    public void setVendorClass(String vendorClass) {
        this.vendorClass = vendorClass;
    }

    public String getVoucherStyle() {
        return voucherStyle;
    }

    public void setVoucherStyle(String voucherStyle) {
        this.voucherStyle = voucherStyle;
    }

    public String getzWf_EAPVLSent() {
        return zWf_EAPVLSent;
    }

    public void setzWf_EAPVLSent(String zWf_EAPVLSent) {
        this.zWf_EAPVLSent = zWf_EAPVLSent;
    }

    public String getzWfApprovalSentDate() {
        return zWfApprovalSentDate;
    }

    public void setzWfApprovalSentDate(String zWfApprovalSentDate) {
        this.zWfApprovalSentDate = zWfApprovalSentDate;
    }

    public String getShipYoId() {
        return shipYoId;
    }

    public void setShipYoId(String shipYoId) {
        this.shipYoId = shipYoId;
    }

    public String getErrorFlag() {
        return errorFlag;
    }

    public void setErrorFlag(String errorFlag) {
        this.errorFlag = errorFlag;
    }

    public String getPaymentHoldReason() {
        return paymentHoldReason;
    }

    public void setPaymentHoldReason(String paymentHoldReason) {
        this.paymentHoldReason = paymentHoldReason;
    }

    public String getzWfApprovalType() {
        return zWfApprovalType;
    }

    public void setzWfApprovalType(String zWfApprovalType) {
        this.zWfApprovalType = zWfApprovalType;
    }

    public String getVoucherSource() {
        return voucherSource;
    }

    public void setVoucherSource(String voucherSource) {
        this.voucherSource = voucherSource;
    }

    public String getMatchAction() {
        return matchAction;
    }

    public void setMatchAction(String matchAction) {
        this.matchAction = matchAction;
    }

    public String getMatchStatusVoucher() {
        return matchStatusVoucher;
    }

    public void setMatchStatusVoucher(String matchStatusVoucher) {
        this.matchStatusVoucher = matchStatusVoucher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntryStatus() {
        return entryStatus;
    }

    public void setEntryStatus(String entryStatus) {
        this.entryStatus = entryStatus;
    }
}
