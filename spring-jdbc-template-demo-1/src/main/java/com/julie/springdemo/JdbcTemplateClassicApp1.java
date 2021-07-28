package com.julie.springdemo;

import com.julie.springdemo.dao.OrganizationDao;
import com.julie.springdemo.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateClassicApp1 {
    public static void main(String[] args) {
        // create the application context
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

        // create the bean
        OrganizationDao organizationDao = (OrganizationDao) ctx.getBean("orgDao");
        List<Organization> orgs = organizationDao.getAllOrganizatios();
        for(Organization org : orgs){
            System.out.println(org);
        }

        //close the application context
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
