package com.julie.springdemo;

import com.julie.springdemo.domain.HumanResourceDepartment;
import com.julie.springdemo.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiConstructorApp {

    public static void main(String[] args) {
        //create the application context (context)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cp.xml");

        //create the bean
        Organization org = (Organization)ctx.getBean("myorg");

        //print the company slogan
        System.out.println(org.corporateSlogan());

        //print organization details.
        System.out.println(org);

        //invoke corporateService via organization bean
        System.out.println(org.corporateService());

        HumanResourceDepartment hrDept = (HumanResourceDepartment)ctx.getBean("mydept") ;
        System.out.println(hrDept.hiringStatus(5000));

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
