package com.example.ec2_aws.controller.person.models;

public class PersonRequestModel {

    private String name;
    private Integer age;
    private String city;
    private String street;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
