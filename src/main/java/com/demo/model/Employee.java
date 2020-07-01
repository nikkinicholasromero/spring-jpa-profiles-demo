package com.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private double salary;
    private LocalDate someDate;
    private LocalTime someTime;
    private LocalDateTime someDatetime;
    private boolean active;
}
