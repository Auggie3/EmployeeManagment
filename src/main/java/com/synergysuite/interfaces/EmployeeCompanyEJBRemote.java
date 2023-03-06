package com.synergysuite.interfaces;

import com.synergysuite.entities.EmployeeCompany;

import jakarta.ejb.Remote;
import jakarta.validation.constraints.NotNull;

@Remote
public interface EmployeeCompanyEJBRemote {
    @NotNull EmployeeCompany createEmployeeCompany(@NotNull EmployeeCompany ec);
    void deleteEmployeeCompany(@NotNull Integer id);
}
