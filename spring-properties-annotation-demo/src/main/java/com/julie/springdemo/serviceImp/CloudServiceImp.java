package com.julie.springdemo.serviceImp;

import com.julie.springdemo.service.BusinessService;

import java.util.Random;

public class CloudServiceImp implements BusinessService {
    @Override
    public String offerService(String companyName) {
        Random random = new Random();
        String service =  "\nAs an Organization, " + companyName
                        + " offers world class Cloud computing infrastructure. "
                        + "\nThe annual income exceeds " + random.nextInt(revenue) + " dollars.";

        return service;
    }

    public void postContruct(){
        System.out.println("cloudServiceImpl: postConstruct called");
    }

    public void preDestroy(){
        System.out.println("cloudServiceImpl: preDestroy called");
    }
}
