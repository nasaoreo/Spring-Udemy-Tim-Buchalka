package com.julie.springdemo;

import com.julie.springdemo.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertiesWithAnnotationApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyConfig.class);

        Organization org = (Organization)ctx.getBean("myorg");

        System.out.println(org);
        System.out.println("slogan : " + org.corporateSlogan());

        ((AnnotationConfigApplicationContext)ctx).close();
    }
}
