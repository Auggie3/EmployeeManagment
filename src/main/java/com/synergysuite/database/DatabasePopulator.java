package com.synergysuite.database;

import com.synergysuite.services.CompanyEJB;
import com.synergysuite.services.EmployeeCompanyEJB;
import com.synergysuite.services.EmployeeEJB;
import com.synergysuite.entities.Company;
import com.synergysuite.entities.Employee;
import com.synergysuite.entities.EmployeeCompany;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class DatabasePopulator {

    @Inject
    private EmployeeEJB employeeEJB;
    @Inject
    private CompanyEJB companyEJB;
    @Inject
    private EmployeeCompanyEJB employeeCompanyEJB;

    private Employee employee1;
    private Employee employee2;
    private Company company;
    private EmployeeCompany pastExperience;

    @PostConstruct
    private void populateDB() throws ParseException {
        employee1 = new Employee("Ogi", "Gio", new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15") , "intern");
        company = new Company("COM");
        pastExperience = new EmployeeCompany(employee1, company,
                new SimpleDateFormat("yyyy-MM-dd").parse("2014-11-15"),
                new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-15"));

        List<EmployeeCompany> pastExperiences = new ArrayList<>();
        pastExperiences.add(pastExperience);


        employee1.setPastExperiences(pastExperiences);

        employee2 = new Employee("Test", "Est", new SimpleDateFormat("yyyy-MM-dd").parse("2013-12-12"),"CEO");

        employeeEJB.createEmployee(employee1);
        employeeEJB.createEmployee(employee2);
        companyEJB.createCompany(company);
        employeeCompanyEJB.createEmployeeCompany(pastExperience);
    }


}
