package com.example.SpringSecurity_Register_Login.restController;


import com.example.SpringSecurity_Register_Login.entity.Customer;
import com.example.SpringSecurity_Register_Login.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
                RequestMethod.OPTIONS})
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add_Customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer saveCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(saveCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/listOfCustomer")
//    @CrossOrigin(origins = "http://localhost:3000")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/delete_Customer/{id}")
//    @CrossOrigin(origins = "http://localhost:3000")
    public boolean deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/get_Customer/{id}")
//    @CrossOrigin(origins = "http://localhost:3000")
    public Customer getCustomer(@PathVariable int id){

        return customerService.getCustomer(id);
    }
}
