package com.julie.springdemo;

import com.julie.springdemo.domain.promotion.TradeFair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentAnnotationApp {

    public static void main(String[] args) {
        //create the application context (context)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");

        TradeFair tradeFair = (TradeFair)ctx.getBean("tradeFair");
        System.out.println(tradeFair.specialPromotionPricing());

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
