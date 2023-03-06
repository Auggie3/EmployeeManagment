package com.synergysuite.controllers;


import com.synergysuite.dto.PastExperienceDTO;
import com.synergysuite.entities.Company;
import com.synergysuite.entities.Employee;
import com.synergysuite.entities.EmployeeCompany;
import com.synergysuite.services.CompanyEJB;
import com.synergysuite.services.EmployeeCompanyEJB;
import com.synergysuite.services.EmployeeEJB;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Date;
import java.util.logging.Logger;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController {
    @Inject
    EmployeeEJB employeeEJB;
    @Inject
    CompanyEJB companyEJB;
    @Inject
    EmployeeCompanyEJB employeeCompanyEJB;

    private Logger logger;


    @GET
    public Response findAll(){
        return Response.ok(employeeEJB.findEmployees()).build();
    }

    @GET
    @Path("{id}")
    public Response findEmployeeById(@PathParam("id") Integer id){
        return Response.ok(employeeEJB.findEmployeeById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployee( Employee employee){
        Integer employeeId = employeeEJB.createEmployee(employee).getId();
        return Response.ok(employeeId).build();
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmployee(Employee employee){
        employeeEJB.updateEmployee(employee);
        Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public void deleteEmployee(@PathParam("id") Integer id){
        employeeEJB.deleteEmployee(id);
        Response.ok().build();
    }

    @POST
    @Path("experience")
    public void addExperience(PastExperienceDTO experienceDTO){

        Company c;
        if(companyEJB.findCompanyByName(experienceDTO.getCompanyName())==null) {
            c = companyEJB.createCompany(new Company(experienceDTO.getCompanyName()));
        }else{
            c = companyEJB.findCompanyByName(experienceDTO.getCompanyName());
        }

        EmployeeCompany employeeCompany = new EmployeeCompany(employeeEJB.findEmployeeById(
                experienceDTO.getEmployeeId()
        ),
                c,experienceDTO.getStart(),
                experienceDTO.getEnd());

        employeeCompanyEJB.createEmployeeCompany(employeeCompany);

        Response.ok().build();
    }


    @DELETE
    @Path("/experience/{id}")
    public Response deleteExperience(@PathParam("id") Integer id){
        employeeCompanyEJB.deleteEmployeeCompany(id);
        return Response.ok().build();
    }



}
