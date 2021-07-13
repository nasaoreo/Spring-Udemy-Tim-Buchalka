package com.julie.springdemo;

import com.julie.springdemo.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesXmlApp {

    public static void main(String[] args) {
        //create the application context (context)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");

        Organization organization = (Organization)ctx.getBean("myorg");
        System.out.println(organization);

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
