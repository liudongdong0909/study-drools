package com.study.drools.model;

/**
 * @author walle
 * @version 1.0
 * @create 2019-03-10
 */
public class Address {

    private String postcode;

    private String street;

    private String state;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
