package edu.nju.expressMgmtSys.model;

import java.io.Serializable;

public class Customer implements Serializable{
    private static final long serialVersionUID = 7346182571696044900L;

    private String name;
    private String address;
    private String company;
    private String telephone;
    private String mobile;

    public Customer(String name, String address, String company, String telephone, String mobile) {
        this.name = name;
        this.address = address;
        this.company = company;
        this.telephone = telephone;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCompany() {
        return company;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMobile() {
        return mobile;
    }
}
