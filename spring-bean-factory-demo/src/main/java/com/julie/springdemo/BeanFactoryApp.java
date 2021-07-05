package com.julie.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryApp {

    public static void main(String[] args) {
        //create the application context (context)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");

        //create the bean
        Organization org = (Organization)ctx.getBean("myorg");
        Organization org2 = (Organization)ctx.getBean("myorg2");

//        //invoke the company slogan via the bean
//        org.corporateSlogan();

        //print organization details
        System.out.println(org);
        System.out.println(org2);

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
