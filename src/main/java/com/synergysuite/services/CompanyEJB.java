package com.synergysuite.services;

import com.synergysuite.entities.Company;
import com.synergysuite.interfaces.CompanyEJBRemote;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Stateless
@LocalBean
public class CompanyEJB implements CompanyEJBRemote {
    @PersistenceContext
    private EntityManager em;

    @Override
    public @NotNull Company createCompany(@NotNull Company company){
        em.persist(company);
        return company;
    }

    @Override
    public Company findCompanyByName(@NotNull String companyName) {

        List<Company> l = em.createNamedQuery(Company.FIND_COMPANY_BY_NAME)
                .setParameter("fname",companyName)
                .getResultList();

        if(l.size()>0) return l.get(0);
        return null;
    }
}
