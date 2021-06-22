package com.julie.springdemo;

public class Organization {

    private String companyName;
    private int yearOfIncorporation;
    private String postalCode;
    private int employeeCount;

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Organization(String companyName, int yearOfIncorporation) {
        this.companyName = companyName;
        this.yearOfIncorporation = yearOfIncorporation;
    }

    public void corporateSlogan(){
        String slogan = "We build the ultimate driving machines!";
        System.out.println(slogan);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "companyName='" + companyName + '\'' +
                ", yearOfIncorporation=" + yearOfIncorporation +
                ", postalCode='" + postalCode + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
