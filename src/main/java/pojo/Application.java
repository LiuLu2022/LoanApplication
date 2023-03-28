package pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Application {
    private Integer id;

    private Integer customerSsn;

    private String fullName;

    private BigDecimal loanAmount;

    private BigDecimal equityAmount;

    private BigDecimal salaryAmount;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerSsn() {
        return customerSsn;
    }

    public void setCustomerSsn(Integer customerSsn) {
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
