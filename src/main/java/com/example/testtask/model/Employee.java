package com.example.testtask.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private int departmentId;
    private String jobTitle;
    private String gender;

}
