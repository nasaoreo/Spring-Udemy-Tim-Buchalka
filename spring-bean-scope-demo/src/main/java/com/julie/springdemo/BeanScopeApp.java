package com.julie.springdemo;

import com.julie.springdemo.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

    public static void main(String[] args) {
        //create the application context (context)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");

        //create the bean
        Organization org = (Organization)ctx.getBean("myorg");
        Organization org2 = (Organization)ctx.getBean("myorg");
        org2.setPostalCode("98989");

        //print the company slogan
//        System.out.println(org.corporateSlogan());

        //print organization details.
        System.out.println(org);
        System.out.println(org2);

        if(org == org2)
            System.out.println("Singleton scope test : org and org2 point to the same instance");
        else
            System.out.println("Both org and org2 are separate instance");

        //invoke corporateService via organization bean
//        System.out.println(org.corporateService());

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
