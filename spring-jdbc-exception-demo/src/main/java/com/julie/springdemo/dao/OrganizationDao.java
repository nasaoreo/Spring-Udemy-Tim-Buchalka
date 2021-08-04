package com.julie.springdemo.dao;

import com.julie.springdemo.domain.Organization;

import javax.sql.DataSource;
import java.util.List;

public interface OrganizationDao {

    //Set the data-source that will be required to create a connection to the database.
    public void setDataSource(DataSource dataSource);

    //Create a record in the organization table.
    public boolean create(Organization org);

    //Retrieve a single organization.
    public Organization getOrganization(Integer id);

    //Retrieve all organizations from the table.
    public List<Organization> getAllOrganizatios();

    //Delete a specific organization from the table.
    public boolean delete(Organization org);

    //Update an existing orgazniation.
    public boolean update(Organization org);

    public void cleanUp();
}
