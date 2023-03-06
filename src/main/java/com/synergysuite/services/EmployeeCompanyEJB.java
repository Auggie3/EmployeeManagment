package com.synergysuite.services;

import com.synergysuite.entities.EmployeeCompany;
import com.synergysuite.interfaces.EmployeeCompanyEJBRemote;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.NotNull;

@Stateless
@LocalBean
public class EmployeeCompanyEJB implements EmployeeCompanyEJBRemote {

    @PersistenceContext
    private EntityManager em;

    public @NotNull EmployeeCompany createEmployeeCompany(@NotNull EmployeeCompany ec){
        em.persist(ec);
        return ec;
    }

    @Override
    public void deleteEmployeeCompany(Integer id) {
        em.createNamedQuery(EmployeeCompany.DELETE_EXPERIENCE)
                .setParameter("id",id)
                .executeUpdate();
    }
}
