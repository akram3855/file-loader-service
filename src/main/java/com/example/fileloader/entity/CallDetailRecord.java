package com.example.fileloader.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "call_detail_records")
public class CallDetailRecord {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;   // primary key from file

    @Column(name = "RECORD_DATE")
    private LocalDateTime recordDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "TYPE")
    private String type;

    // --- Local details ---
    @Column(name = "L_SPC")
    private Integer lSpc;

    @Column(name = "L_SSN")
    private Integer lSsn;

    @Column(name = "L_RI")
    private Integer lRi;

    @Column(name = "L_GT_I")
    private Integer lGtI;

    @Column(name = "L_GT_DIGITS")
    private String lGtDigits;

    // --- Remote details ---
    @Column(name = "R_SPC")
    private Integer rSpc;

    @Column(name = "R_SSN")
    private Integer rSsn;

    @Column(name = "R_RI")
    private Integer rRi;

    @Column(name = "R_GT_I")
    private Integer rGtI;

    @Column(name = "R_GT_DIGITS")
    private String rGtDigits;

    // --- Service / subscriber ---
    @Column(name = "SERVICE_CODE")
    private String serviceCode;

    @Column(name = "OR_NATURE")
    private Integer orNature;

    @Column(name = "OR_PLAN")
    private Integer orPlan;

    @Column(name = "OR_DIGITS")
    private String orDigits;

    @Column(name = "DE_NATURE")
    private Integer deNature;

    @Column(name = "DE_PLAN")
    private Integer dePlan;

    @Column(name = "DE_DIGITS")
    private String deDigits;

    @Column(name = "ISDN_NATURE")
    private Integer isdnNature;

    @Column(name = "ISDN_PLAN")
    private Integer isdnPlan;

    @Column(name = "MSISDN")
    private String msisdn;

    @Column(name = "VLR_NATURE")
    private Integer vlrNature;

    @Column(name = "VLR_PLAN")
    private Integer vlrPlan;

    @Column(name = "VLR_DIGITS")
    private String vlrDigits;

    @Column(name = "IMSI")
    private String imsi;

    // --- Dialog info ---
    @Column(name = "TSTAMP")
    private LocalDateTime tstamp;

    @Column(name = "LOCAL_DIALOG_ID")
    private Long localDialogId;

    @Column(name = "REMOTE_DIALOG_ID")
    private Long remoteDialogId;

    @Column(name = "DIALOG_DURATION")
    private Long dialogDuration;

    @Column(name = "USSD_STRING")
    private String ussdString;

    // --- Getters & Setters ---

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDateTime getRecordDate() { return recordDate; }
    public void setRecordDate(LocalDateTime recordDate) { this.recordDate = recordDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Integer getLSpc() { return lSpc; }
    public void setLSpc(Integer lSpc) { this.lSpc = lSpc; }

    public Integer getLSsn() { return lSsn; }
    public void setLSsn(Integer lSsn) { this.lSsn = lSsn; }

    public Integer getLRi() { return lRi; }
    public void setLRi(Integer lRi) { this.lRi = lRi; }

    public Integer getLGtI() { return lGtI; }
    public void setLGtI(Integer lGtI) { this.lGtI = lGtI; }

    public String getLGtDigits() { return lGtDigits; }
    public void setLGtDigits(String lGtDigits) { this.lGtDigits = lGtDigits; }

    public Integer getRSpc() { return rSpc; }
    public void setRSpc(Integer rSpc) { this.rSpc = rSpc; }

    public Integer getRSsn() { return rSsn; }
    public void setRSsn(Integer rSsn) { this.rSsn = rSsn; }

    public Integer getRRi() { return rRi; }
    public void setRRi(Integer rRi) { this.rRi = rRi; }

    public Integer getRGtI() { return rGtI; }
    public void setRGtI(Integer rGtI) { this.rGtI = rGtI; }

    public String getRGtDigits() { return rGtDigits; }
    public void setRGtDigits(String rGtDigits) { this.rGtDigits = rGtDigits; }

    public String getServiceCode() { return serviceCode; }
    public void setServiceCode(String serviceCode) { this.serviceCode = serviceCode; }

    public Integer getOrNature() { return orNature; }
    public void setOrNature(Integer orNature) { this.orNature = orNature; }

    public Integer getOrPlan() { return orPlan; }
    public void setOrPlan(Integer orPlan) { this.orPlan = orPlan; }

    public String getOrDigits() { return orDigits; }
    public void setOrDigits(String orDigits) { this.orDigits = orDigits; }

    public Integer getDeNature() { return deNature; }
    public void setDeNature(Integer deNature) { this.deNature = deNature; }

    public Integer getDePlan() { return dePlan; }
    public void setDePlan(Integer dePlan) { this.dePlan = dePlan; }

    public String getDeDigits() { return deDigits; }
    public void setDeDigits(String deDigits) { this.deDigits = deDigits; }

    public Integer getIsdnNature() { return isdnNature; }
    public void setIsdnNature(Integer isdnNature) { this.isdnNature = isdnNature; }

    public Integer getIsdnPlan() { return isdnPlan; }
    public void setIsdnPlan(Integer isdnPlan) { this.isdnPlan = isdnPlan; }

    public String getMsisdn() { return msisdn; }
    public void setMsisdn(String msisdn) { this.msisdn = msisdn; }

    public Integer getVlrNature() { return vlrNature; }
    public void setVlrNature(Integer vlrNature) { this.vlrNature = vlrNature; }

    public Integer getVlrPlan() { return vlrPlan; }
    public void setVlrPlan(Integer vlrPlan) { this.vlrPlan = vlrPlan; }

    public String getVlrDigits() { return vlrDigits; }
    public void setVlrDigits(String vlrDigits) { this.vlrDigits = vlrDigits; }

    public String getImsi() { return imsi; }
    public void setImsi(String imsi) { this.imsi = imsi; }

    public LocalDateTime getTstamp() { return tstamp; }
    public void setTstamp(LocalDateTime tstamp) { this.tstamp = tstamp; }

    public Long getLocalDialogId() { return localDialogId; }
    public void setLocalDialogId(Long localDialogId) { this.localDialogId = localDialogId; }

    public Long getRemoteDialogId() { return remoteDialogId; }
    public void setRemoteDialogId(Long remoteDialogId) { this.remoteDialogId = remoteDialogId; }

    public Long getDialogDuration() { return dialogDuration; }
    public void setDialogDuration(Long dialogDuration) { this.dialogDuration = dialogDuration; }

    public String getUssdString() { return ussdString; }
    public void setUssdString(String ussdString) { this.ussdString = ussdString; }
}
