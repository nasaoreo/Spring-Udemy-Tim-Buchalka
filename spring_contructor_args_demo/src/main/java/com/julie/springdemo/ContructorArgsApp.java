package com.julie.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContructorArgsApp {

    public static void main(String[] args) {
        //create the application context (context)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");

        //create the bean
        Organization org = (Organization)ctx.getBean("myorg");

        //invoke the company slogan via the bean
        org.corporateSlogan();

        //pring organization details.
        System.out.println(org);

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
