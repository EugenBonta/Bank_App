package com.demo.bankapp.entity;

public class Account {

    private Long id;
    private String clientIdnp;
    private String currency;
    private Double funds;

    public Account(Long id, String clientIdnp, String currency, Double funds) {
        this.id = id;
        this.clientIdnp = clientIdnp;
        this.currency = currency;
        this.funds = funds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientIdnp() {
        return clientIdnp;
    }

    public void setClientIdnp(String clientIdnp) {
        this.clientIdnp = clientIdnp;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getFunds() {
        return funds;
    }

    public void setFunds(Double funds) {
        this.funds = funds;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", clientIdnp=" + clientIdnp +
                ", currency='" + currency + '\'' +
                ", funds=" + funds +
                '}';
    }
}
