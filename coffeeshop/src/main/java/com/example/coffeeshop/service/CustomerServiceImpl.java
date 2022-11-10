package com.example.coffeeshop.service;

import com.example.coffeeshop.entity.Customer;
import com.example.coffeeshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository repository;


    @Override
    public List<Customer> showAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Customer updateCustomer(Customer customer, int id) throws AccountNotFoundException {

        Customer existingCustomer = repository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException());


        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setEmailAddress(customer.getEmailAddress());

        repository.save(existingCustomer);

        return existingCustomer;
    }

    @Override
    public void deleteCustomer(int id) throws AccountNotFoundException {
        if(!repository.existsById(id)) {
            throw new AccountNotFoundException();
        }
        repository.deleteById(id);

    }
    @Override
    public Customer findByEmailAddress(String email) {
        Customer customerWithEmail = repository.findByEmailAddress(email);
        return customerWithEmail;
    }
}
