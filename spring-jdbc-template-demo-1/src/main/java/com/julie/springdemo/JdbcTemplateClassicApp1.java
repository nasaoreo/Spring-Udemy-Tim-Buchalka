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

        // create seed data
        DaoUtils.createSeedData(organizationDao);

        // get list of organizations
        List<Organization> orgs = organizationDao.getAllOrganizatios();
        DaoUtils.pringOrganizations(orgs, DaoUtils.readOperation);

        // create a new organization record
        Organization org = new Organization("General Electric", 1989, "98989", 5776, "Imagination at work");
        boolean isCreated = organizationDao.create(org);
        DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
        DaoUtils.pringOrganizationCount(organizationDao.getAllOrganizatios(), DaoUtils.createOperation);
        DaoUtils.pringOrganizations(organizationDao.getAllOrganizatios(), DaoUtils.readOperation);

        // clean-up
        organizationDao.cleanUp();
        DaoUtils.pringOrganizationCount(organizationDao.getAllOrganizatios(), DaoUtils.cleanupOperation);

        //close the application context
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
