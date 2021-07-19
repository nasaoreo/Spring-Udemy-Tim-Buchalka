package com.julie.springdemo.daoimpl;


import com.julie.springdemo.domain.Organization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationRowMapper implements RowMapper<Organization> {

    public Organization mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Organization org = new Organization();
        org.setId(resultSet.getInt("id"));
        org.setCompanyName(resultSet.getString("company_name"));
        org.setYearOfIncorporation(resultSet.getInt("year_of_incorporation"));
        org.setPostalCode(resultSet.getString("postal_code"));
        org.setSlogan(resultSet.getString("slogan"));

        return org;
    }
}
