package com.julie.springdemo.domain;

import com.julie.springdemo.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("myorg")
public class Organization {

    @Value("${nameOfComapany}")
    private String companyName;

    @Value("${startUpYear}")
    private int yearOfIncorporation;

    @Value("${postalCode}")
    private String postalCode;

    @Value("${empCount:22222}")
    private int employeeCount;

    @Value("${corporateSlogan:We build world class software!}")
    private String slogan;

    private String missionStatement;

    @Autowired
    private Environment env;

    private BusinessService businessService;

    public Organization(){
        System.out.println("default constructor called");
    }

    public String corporateSlogan(){
        missionStatement = env.getProperty("statement");
        return missionStatement + "and also " + slogan;
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

    public void setSlogan(String slogan) {
        this.slogan = slogan;
        System.out.println("setSlogan() called");
    }

    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
        System.out.println("setBusinessService() called");
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
