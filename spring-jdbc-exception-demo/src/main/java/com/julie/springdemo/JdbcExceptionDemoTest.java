package com.julie.springdemo;

import com.julie.springdemo.dao.OrganizationDao;
import com.julie.springdemo.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcExceptionDemoTest {
    public static void main(String[] args) {
        // create the application context
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

        // create the bean
        OrganizationDao organizationDao = (OrganizationDao) ctx.getBean("orgDao");

        // create seed data
        DaoUtils.createSeedData(organizationDao);

        // get list of organizations
        List<Organization> orgs = organizationDao.getAllOrganizatios();
        DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);

        // create a new organization record
        Organization org = new Organization("General Electric", 1989, "98989", 5776, "Imagination at work");
        boolean isCreated = organizationDao.create(org);
        DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
        DaoUtils.printOrganizationCount(organizationDao.getAllOrganizatios(), DaoUtils.createOperation);
        DaoUtils.printOrganizations(organizationDao.getAllOrganizatios(), DaoUtils.readOperation);

        // get a single organization
        Organization org2 = organizationDao.getOrganization(1);
        DaoUtils.printOrganization(org2, "getOrganization");

        // update a slogan for an organization
        Organization org3 = organizationDao.getOrganization(2);
        org3.setSlogan("We build ** awesome ** driving machines!");
        boolean isUpdated = organizationDao.update(org3);
        DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
        DaoUtils.printOrganization(organizationDao.getOrganization(2), DaoUtils.updateOperation);

        // delete an organization
        boolean isDeleted = organizationDao.delete(org3);
        DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
        DaoUtils.printOrganizations(organizationDao.getAllOrganizatios(), DaoUtils.deleteOperation);

        // clean-up
        organizationDao.cleanUp();
        DaoUtils.printOrganizationCount(organizationDao.getAllOrganizatios(), DaoUtils.cleanupOperation);

        // close the application context
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
