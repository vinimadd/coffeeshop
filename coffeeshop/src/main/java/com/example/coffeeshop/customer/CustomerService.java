package com.example.coffeeshop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService  {

//    private final CustomerRepository customerRepository;
//
//    @Autowired
//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

//    public List<Customer> showAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    public Customer saveCustomer(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    public Customer getCustomer(Long id) {
//        return customerRepository.findById(id).get();
//    }
//
//    @Transactional //use setters to update
//    public Customer updateCustomer(Customer customer, Long id) throws AccountNotFoundException {
//
//        Customer existingCustomer = customerRepository.findById(id)
//                .orElseThrow(AccountNotFoundException::new);
//
////        existingCustomer.setFirstName(customer.getFirstName());
////        existingCustomer.setLastName(customer.getLastName());
////        existingCustomer.setAddress(customer.getAddress());
////        existingCustomer.setCity(customer.getCity());
////        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
////        existingCustomer.setEmailAddress(customer.getEmailAddress());
//
//        customerRepository.save(existingCustomer);
//
//        return existingCustomer;
//    }
//
//    public void deleteCustomer(Long id) throws AccountNotFoundException {
//        if(!customerRepository.existsById(id)) {
//            throw new AccountNotFoundException();
//        }
//        customerRepository.deleteById(id);
//    }
//
//    // needs testing, custom query
//    public Customer findByEmailAddress(String email) {
//        return customerRepository.findByEmailAddress(email);
//    }
}
