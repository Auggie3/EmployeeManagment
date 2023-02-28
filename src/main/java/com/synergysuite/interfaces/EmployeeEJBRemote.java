package com.synergysuite.interfaces;

import com.synergysuite.entities.Employee;

import jakarta.ejb.Remote;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Remote
public interface EmployeeEJBRemote {
    List<Employee> findEmployees();
    @NotNull Employee findEmployeeById(@NotNull Integer id);
    List<Employee> findEmployeeByName(@NotNull String fname, @NotNull String lname);
    @NotNull Employee createEmployee(@NotNull Employee employee);
    @NotNull Employee updateEmployee(@NotNull Employee employee);
    void deleteEmployee(@NotNull Employee employee);
}
