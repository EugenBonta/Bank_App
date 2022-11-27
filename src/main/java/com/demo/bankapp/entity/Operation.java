package com.demo.bankapp.entity;

public class Operation {
    private Long accountId;
    private Double amount;
    private String date;

    public Operation(Long accountId, Double amount, String date) {
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "accountId=" + accountId +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
