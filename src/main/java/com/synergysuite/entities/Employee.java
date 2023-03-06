package com.synergysuite.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static com.synergysuite.entities.Employee.FIND_ALL;
import static com.synergysuite.entities.Employee.FIND_BY_NAME;

@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select e from Employee e"),
        @NamedQuery(name = FIND_BY_NAME, query = "select e from Employee e" +
                " where e.firstname = :fname" +
                " and e.lastname = :lname")
})
public class Employee implements Serializable {

    public static final String FIND_ALL = "Employee.findAll";
    public static final String FIND_BY_NAME = "Employee.findByName";

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String firstname;
    private String lastname;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Belgrade")
    private Date startDate;
    @NotNull
    @Column(nullable = false)
    private String position;
    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<EmployeeCompany> pastExperiences;


    //constructors, getters, setters...

    public Employee() {
    }

    public Employee(String firstname, String lastname, Date startDate, String position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.startDate = startDate;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", startDate=" + startDate +
                ", position='" + position + '\'' +
                ", pastExperiencies=" +getPastExperiences() +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<EmployeeCompany> getPastExperiences() {
        return pastExperiences;
    }

    public void setPastExperiences(List<EmployeeCompany> pastExperiences) {
        this.pastExperiences = pastExperiences;
    }
}
