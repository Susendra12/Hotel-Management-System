package com.example.SpringSecurity_Register_Login.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private int age;
    private String email;
    private String gender;
    @Column(unique = true, length = 7)
    private String customerCode;
    private long phoneNo;
}

