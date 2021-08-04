package com.julie.springdemo.daoimpl;

import com.julie.springdemo.dao.OrganizationDao;
import com.julie.springdemo.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean create(Organization org) {
        String sqlQuery = "insert into organization(company_name, year_of_incorporation, postal_code, employee_count, slogan) "
                + "values(?, ?, ?, ?, ?)";
        Object[] args = new Object[]{org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(), org.getEmployeeCount(), org.getSlogan()};

        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    public Organization getOrganization(Integer id) {
        String sqlQuery = "select id, company_name, year_of_incorporation, postal_code, employee_count, slogan from organization where id=?";
        Object[] args = new Object[]{id};
        Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());

        return org;
    }

    public List<Organization> getAllOrganizatios() {
        String sqlQuery = "selec * from organization";
        List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());

        return orgList;
    }

    public boolean delete(Organization org) {
        String sqlQuery = "delete from organization where id = ?";
        Object[] args = new Object[]{org.getId()};

        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    public boolean update(Organization org) {
        String sqlQuery = "update organization set slogan = ? where id = ?";
        Object[] args = new Object[]{org.getSlogan(), org.getId()};

        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    public void cleanUp() {
        String sqlQuery = "TRUNCATE TABLE organization ";
        jdbcTemplate.execute(sqlQuery);
    }
}
