package com.julie.springdemo;

import com.julie.springdemo.dao.OrganizationDao;
import com.julie.springdemo.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

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
        List<Organization> orgs = null;
        try{
            organizationDao.getAllOrganizatios();
        }
        catch(BadSqlGrammarException bge){
            System.out.println("EXCEPTION MESSAGE : " + bge.getMessage());
            System.out.println("EXCEPTION CLASS : " + bge.getClass());
        }
        catch (DataAccessException dae){
            System.out.println("EXCEPTION MESSAGE : " + dae.getMessage());
            System.out.println("EXCEPTION CLASS : " + dae.getClass());
        }

        DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);

        // clean-up
        organizationDao.cleanUp();
        DaoUtils.printOrganizationCount(organizationDao.getAllOrganizatios(), DaoUtils.cleanupOperation);

        // close the application context
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
