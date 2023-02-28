package com.synergysuite.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@NamedQuery(name = Company.FIND_COMPANY_BY_NAME, query = "Select c from Company c where c.name = :fname")
public class Company implements Serializable {

    public final static String FIND_COMPANY_BY_NAME = "Company.findCompany";

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Column(nullable = false, unique = true)
    private String name;



    //constructors, getters, setters...


    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                    name +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
