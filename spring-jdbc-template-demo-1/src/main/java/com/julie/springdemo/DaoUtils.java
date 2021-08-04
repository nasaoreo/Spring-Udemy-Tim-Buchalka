package com.julie.springdemo;

import com.julie.springdemo.dao.OrganizationDao;
import com.julie.springdemo.domain.Organization;

import java.util.ArrayList;
import java.util.List;

public class DaoUtils {
    public static final String createOperation = "CREATE";
    public static final String readOperation = "READ";
    public static final String updateOperation = "UPDATE";
    public static final String deleteOperation = "DELETE";
    public static final String cleanupOperation = "TRUNCATE";

    public static void printOrganizations(List<Organization> orgs, String operation){
        System.out.println("\n********* printing organizations after " + operation + " operation *********");
        for(Organization org : orgs){
            System.out.println(org);
        }
    }

    public static void printOrganization(Organization org, String operation){
        System.out.println("\n********* printing organizations after invoking " + operation + " *********");
        System.out.println(org);
    }

    public static void printSuccessFailure(String operation, boolean param){
        if(param)
            System.out.println("\nOperation " + operation + " successful");
        else
            System.out.println("\nOperation " + operation + " failed");
    }

    public static void createSeedData(OrganizationDao dao){
        Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
        Organization org2 = new Organization("BMW", 1929, "45454", 5501, "We build ultimate Driving machines");
        Organization org3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");

        List<Organization> orgs = new ArrayList<>();
        orgs.add(org1); orgs.add(org2); orgs.add(org3);

        int createCnt = 0;
        for(Organization org : orgs){
            boolean isCreated = dao.create(org);
            if(isCreated)
                createCnt += 1;
        }

        System.out.println("Created " + createCnt + " organizations");
    }

    public static void printOrganizationCount(List<Organization> orgs, String operation){
        System.out.println("\n********* Currently we have " + orgs.size() + " organizations after "
                + "operation *********");
    }
}
