package com.demo.bankapp.entity;

public class Client {
    private String idnp;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Client(String idnp, String firstName, String lastName, String email, String number) {
        this.idnp = idnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = number;
    }

    public String getIdnp() {
        return idnp;
    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idnp='" + idnp + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", number='" + phoneNumber + '\'' +
                '}';
    }
}
