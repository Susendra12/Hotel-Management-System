package com.example.SpringSecurity_Register_Login.service;

import com.example.SpringSecurity_Register_Login.entity.CodeGeneratorUtil;
import com.example.SpringSecurity_Register_Login.entity.Customer;
import com.example.SpringSecurity_Register_Login.entity.CustomerCodeGenerator;
import com.example.SpringSecurity_Register_Login.entity.CustomerCodeGeneratorRepository;
import com.example.SpringSecurity_Register_Login.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerCodeGeneratorRepository codeGeneratorRepository;


    @Transactional
    public Customer addCustomer(Customer customer) {

//        return customerRepository.save(customer);

        // Fetch or initialize the code generator
        CustomerCodeGenerator generator = codeGeneratorRepository.findById(1L)
                .orElseGet(() -> {
                    CustomerCodeGenerator g = new CustomerCodeGenerator();
                    g.setLastCode("0000000");
                    return g;
                });

        // Generate the next customer code
        String newCode = CodeGeneratorUtil.getNextCode(generator.getLastCode());

        // Assign code to customer and save
        customer.setCustomerCode(newCode);
        Customer savedCustomer = customerRepository.save(customer);

        // Update the generator
        generator.setLastCode(newCode);
        codeGeneratorRepository.save(generator);

        return savedCustomer;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public boolean deleteCustomer(int id) {
        customerRepository.deleteById(id);
        return true;
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id).get();

    }
}
