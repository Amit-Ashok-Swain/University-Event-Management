package com.geekster.project.assignment.UniversityEventManagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Only alphabets are allowed with the first letter as capital")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Only alphabets are allowed with the first letter as capital")
    private String lastName;

    @Min(value = 18)
    @Max(value = 25)
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Department studentDepartment;

}

/*
Student model will have-
StudentId
first name
last name
age
department


I have added validation on age(between 18 -25) ,
first name(first letter should be capital) ,
 department(datatype of variable department should be Enum and not string Enum should support department names line ME , ECE , civil , CSE).

 */