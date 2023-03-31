package com.example.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Loan {
    private Integer id;

    private String customerSsn;

    private String fullName;

    private BigDecimal loanAmount;

    private BigDecimal equityAmount;

    private BigDecimal salaryAmount;

    private Date createTime;

    private Date updateTime;

    public Loan(Integer id, String customerSsn, String fullName, BigDecimal loanAmount, BigDecimal equityAmount, BigDecimal salaryAmount, Date createTime, Date updateTime) {
        this.id = id;
        this.customerSsn = customerSsn;
        this.fullName = fullName;
        this.loanAmount = loanAmount;
        this.equityAmount = equityAmount;
        this.salaryAmount = salaryAmount;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Loan() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerSsn() {
        return customerSsn;
    }

    public void setCustomerSsn(String customerSsn) {
        this.customerSsn = customerSsn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getEquityAmount() {
        return equityAmount;
    }

    public void setEquityAmount(BigDecimal equityAmount) {
        this.equityAmount = equityAmount;
    }

    public BigDecimal getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(BigDecimal salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
