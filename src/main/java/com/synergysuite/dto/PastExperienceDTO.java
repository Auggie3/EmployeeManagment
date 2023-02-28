package com.synergysuite.dto;

import com.synergysuite.entities.Company;

import java.util.Date;

public class PastExperienceDTO {
    Integer employeeId;
    Company company;
    Date start;
    Date end;



    public PastExperienceDTO() {
    }

    public PastExperienceDTO(Integer employeeId, Company company, Date start, Date end) {
        this.employeeId = employeeId;
        this.company = company;
        this.start = start;
        this.end = end;
    }


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "PastExperienceDTO{" +
                "employeeId=" + employeeId +
                ", company=" + company +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
