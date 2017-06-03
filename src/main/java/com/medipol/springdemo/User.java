package com.medipol.springdemo;

public class User {

    private Long id;
    private String name;
    private String surname;
    private String productadd;

    public User(Long id, String name, String surname,String productadd) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.productadd = productadd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getproductadd() {
        return productadd;
    }

    public void setProductadd(String productadd) {
        this.productadd = productadd;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }






}
