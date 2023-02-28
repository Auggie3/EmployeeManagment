package com.synergysuite.interfaces;

import com.synergysuite.entities.Company;

import jakarta.ejb.Remote;
import jakarta.validation.constraints.NotNull;

@Remote
public interface CompanyEJBRemote {
    @NotNull Company createCompany(@NotNull Company company);
    Company findCompanyByName(@NotNull String companyName);
}
