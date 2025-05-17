package com.example.SpringSecurity_Register_Login.restController;

import com.example.SpringSecurity_Register_Login.entity.User;
import com.example.SpringSecurity_Register_Login.repository.UserRepository;
import com.example.SpringSecurity_Register_Login.service.JwtService;
import com.example.SpringSecurity_Register_Login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwt;

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to kd";
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User user) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
//
//            if (authentication.isAuthenticated()) {
//                String token = jwt.generateToken(user.getEmail());
//                return ResponseEntity.ok(token);
//            }
//        } catch (Exception e) {
//            e.printStackTrace(); // Debugging
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials");
//    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

            if (authentication.isAuthenticated()) {
                String token = jwt.generateToken(user.getEmail());
                return ResponseEntity.ok(Map.of("token", token));
            }
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid Credentials"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "An error occurred"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Invalid Request"));
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        String encodedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPwd);

        userRepository.save(user);

        return "User registered";
    }
}
