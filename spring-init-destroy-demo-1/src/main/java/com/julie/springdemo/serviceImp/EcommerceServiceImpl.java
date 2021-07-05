package com.julie.springdemo.serviceImp;

import com.julie.springdemo.service.BusinessService;

import java.util.Random;

public class EcommerceServiceImpl implements BusinessService {
    @Override
    public String offerService(String companyName) {
        Random random = new Random();
        String service =  "\nAs an Organization, " + companyName
                + " provides an outstanding Ecommerce platform. "
                + "\nThe annual income exceeds " + random.nextInt(revenue) + " dollars.";

        return service;
    }
}
