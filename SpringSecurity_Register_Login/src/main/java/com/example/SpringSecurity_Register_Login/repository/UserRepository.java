package com.example.SpringSecurity_Register_Login.repository;

import com.example.SpringSecurity_Register_Login.entity.User;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = :email ORDER BY u.id ASC LIMIT 1")
    Optional<User> findByEmail(@Param("email") String email);

}
