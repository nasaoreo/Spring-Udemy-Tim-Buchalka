package com.julie.springdemo.domain;

import com.julie.springdemo.service.RecruitmentService;

public class HumanResourceDepartment implements Department{
    private String departmentName;
    private RecruitmentService recruitmentService;
    private Organization organization;

    public HumanResourceDepartment(RecruitmentService recruitmentService, Organization organization) {
        this.recruitmentService = recruitmentService;
        this.organization = organization;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String hiringStatus(int numberOfRecruitments) {
        String hiringFacts = recruitmentService.recruitEmployees(organization.getCompanyName(), departmentName, numberOfRecruitments);
        return hiringFacts;
    }
}
