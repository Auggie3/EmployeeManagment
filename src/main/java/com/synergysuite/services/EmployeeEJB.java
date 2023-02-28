package com.synergysuite.services;

import com.synergysuite.entities.Employee;
import com.synergysuite.interfaces.EmployeeEJBRemote;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Stateless
@LocalBean
public class EmployeeEJB implements EmployeeEJBRemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> findEmployees() {
        Query q = em.createNamedQuery(Employee.FIND_ALL);
        List<Employee> allEmployees = q.getResultList();
        return allEmployees;
    }

    @Override
    public @NotNull Employee findEmployeeById(@NotNull Integer id){
        return em.find(Employee.class,id);
    }

    @Override
    public List<Employee> findEmployeeByName(@NotNull String fname, @NotNull String lname){
       Query q = em.createNamedQuery(Employee.FIND_BY_NAME);
       q.setParameter("fname", fname);
       q.setParameter("lname", lname);

       List<Employee> employees = q.getResultList();
       return employees;
    }

    @Override
    public @NotNull Employee createEmployee(@NotNull Employee employee){
        em.persist(employee);
        return employee;
    }

    @Override
    public @NotNull Employee updateEmployee(@NotNull Employee employee){
        em.merge(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(@NotNull Employee employee) {
        em.remove(employee);
    }

}
