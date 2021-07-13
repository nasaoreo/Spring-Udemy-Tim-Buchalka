package com.julie.springdemo;

import com.julie.springdemo.domain.product.ConsumerProduct;
import com.julie.springdemo.domain.product.IndustrialProduct;
import com.julie.springdemo.domain.promotion.TradeFair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredAnnotationApp {

    public static void main(String[] args) {
        //create the application context (context)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");

        TradeFair tradeFair = (TradeFair)ctx.getBean(TradeFair.class);
        System.out.println(tradeFair.specialPromotionPricing());

        IndustrialProduct industrialProduct = (IndustrialProduct)ctx.getBean("industrialProduct");
        System.out.println(" * Industrial Prouduct Price : $"+tradeFair.declareIndustrialProductPrice(industrialProduct));

        ConsumerProduct consumerProduct = (ConsumerProduct)ctx.getBean("consumerProduct");
        System.out.println(" * Consumer Prouduct Price : $"+tradeFair.declareConsumerProductPrice(consumerProduct));

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
