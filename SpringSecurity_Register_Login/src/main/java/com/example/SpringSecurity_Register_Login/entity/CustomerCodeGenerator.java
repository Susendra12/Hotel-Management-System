package com.example.SpringSecurity_Register_Login.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CustomerCodeGenerator {

    @Id
    private Long id = 1L;

    private String lastCode = "0000000";
}
