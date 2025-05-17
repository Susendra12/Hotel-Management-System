package com.example.SpringSecurity_Register_Login.service;

import com.example.SpringSecurity_Register_Login.entity.User;
import com.example.SpringSecurity_Register_Login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    /*@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User u = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(u.getEmail(),u.getPassword(),Collections.emptyList());
    }*/


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        return user;
    }

//    public boolean saveUser(User user){
//
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        User savedUser = userRepository.save(user);
//        return savedUser.getId() != null;
//    }
}
