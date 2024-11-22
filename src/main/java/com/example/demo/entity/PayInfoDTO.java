package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lijixin
 * @date 2023/11/27
 * @apiNote
 */
@Data
public class PayInfoDTO {
    private int feeBatch;
    private BigDecimal feeSumamt;
    private String payRsltType;
    private String medItemSn;
    private String polItemCode;
    private int paySn;
    private String fundMnyCode;
    private String feeSn;
    private String payFlag;
    private String payDate;

    public int getFeeBatch() {
        return feeBatch;
    }

    public void setFeeBatch(int feeBatch) {
        this.feeBatch = feeBatch;
    }

    public BigDecimal getFeeSumamt() {
        return feeSumamt;
    }

    public void setFeeSumamt(BigDecimal feeSumamt) {
        this.feeSumamt = feeSumamt;
    }

    public String getPayRsltType() {
        return payRsltType;
    }

    public void setPayRsltType(String payRsltType) {
        this.payRsltType = payRsltType;
    }

    public String getMedItemSn() {
        return medItemSn;
    }

    public void setMedItemSn(String medItemSn) {
        this.medItemSn = medItemSn;
    }

    public String getPolItemCode() {
        return polItemCode;
    }

    public void setPolItemCode(String polItemCode) {
        this.polItemCode = polItemCode;
    }

    public int getPaySn() {
        return paySn;
    }

    public void setPaySn(int paySn) {
        this.paySn = paySn;
    }

    public String getFundMnyCode() {
        return fundMnyCode;
    }

    public void setFundMnyCode(String fundMnyCode) {
        this.fundMnyCode = fundMnyCode;
    }

    public String getFeeSn() {
        return feeSn;
    }

    public void setFeeSn(String feeSn) {
        this.feeSn = feeSn;
    }

    public String getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
}
