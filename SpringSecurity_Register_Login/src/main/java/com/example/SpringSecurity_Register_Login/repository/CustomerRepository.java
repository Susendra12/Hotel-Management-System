package com.example.SpringSecurity_Register_Login.repository;

import com.example.SpringSecurity_Register_Login.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
