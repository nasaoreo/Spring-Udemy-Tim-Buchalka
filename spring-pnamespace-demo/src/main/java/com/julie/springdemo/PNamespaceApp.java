package com.julie.springdemo;

import com.julie.springdemo.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PNamespaceApp {

    public static void main(String[] args) {
        //create the application context (context)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");

        //create the bean
        Organization org = (Organization)ctx.getBean("myorg");

        //pring organization details.
        System.out.println(org);

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
