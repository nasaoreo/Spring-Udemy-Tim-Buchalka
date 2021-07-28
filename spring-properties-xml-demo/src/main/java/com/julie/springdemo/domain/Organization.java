package com.julie.springdemo.domain;

import com.julie.springdemo.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Organization {

    private String companyName;
    private int yearOfIncorporation;

    @Value("${org.postalCode}")
    private String postalCode;

    private int employeeCount;
    private String slogan;
    private BusinessService businessService;

    public Organization(){
        System.out.println("default constructor called");
    }

    public Organization(String companyName, int yearOfIncorporation) {
        this.companyName = companyName;
        this.yearOfIncorporation = yearOfIncorporation;
        System.out.println("constructor called");
    }

    public void postContruct(){
        System.out.println("organization: postConstruct called");
    }

    public void preDestroy(){
        System.out.println("organization: preDestroy called");
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        System.out.println("setPostalCode() called");
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
        System.out.println("setEmployeeCount() called");
    }

    @Autowired
    public void setSlogan(@Value("${org.slogan}") String slogan) {
        this.slogan = slogan;
        System.out.println("setSlogan() called");
    }

    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
        System.out.println("setBusinessService() called");
    }

    public String corporateSlogan(){
        return slogan;
    }

    public String corporateService(){
        return businessService.offerService(companyName);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "companyName='" + companyName + '\'' +
                ", yearOfIncorporation=" + yearOfIncorporation +
                ", postalCode='" + postalCode + '\'' +
                ", employeeCount=" + employeeCount +
                ", slogan='" + slogan + '\'' +
                '}';
    }
}