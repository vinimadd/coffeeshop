package com.example.coffeeshop.customer;

import com.example.coffeeshop.customer.error.CustomerNotFoundException;
import com.example.coffeeshop.customer.error.EmailTakenError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService  {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public void saveCustomer(Customer newCustomer) {
        Optional<Customer> customerByEmailAddress = customerRepository.findByEmailAddress(newCustomer.getEmailAddress());

        if (customerByEmailAddress.isPresent()) {
            //TODO: create custom exception
            throw new EmailTakenError("This email address is taken");
        }
        customerRepository.save(newCustomer);
    }

    public Customer findCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);

        if (!exists) {
            //TODO: create custom exception
            throw new CustomerNotFoundException("There is no user with id " + customerId);
        }
        return customerRepository.findById(customerId).get();
    }

    @Transactional //use setters to update
    public void updateCustomer(Long customerId, String emailAddress, String phoneNumber, String customerAddress) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("There is no user with id " + customerId));

        if (emailAddress != null && emailAddress.length() > 0
                && !Objects.equals(customer.getEmailAddress(), emailAddress)) {

            Optional<Customer> customerByEmailAddress =
                    customerRepository.findByEmailAddress(emailAddress); //find by newly added email

            if (customerByEmailAddress.isPresent()) {
                throw new EmailTakenError("This email address is taken");
            }
            customer.setEmailAddress(emailAddress);
        }

        if (phoneNumber != null && phoneNumber.length() > 0
                && !Objects.equals(customer.getPhoneNumber(), phoneNumber)) {
            customer.setPhoneNumber(phoneNumber);
        }

        if (customerAddress != null && customerAddress.length() > 0
                && !Objects.equals(customer.getAddress(), customerAddress)) {
            customer.setAddress(customerAddress);
        }
    }

    public void deleteCustomer(Long customerId)  {
        boolean exists = customerRepository.existsById(customerId);

        if(!exists) {
            //TODO: create custom exception
            throw new CustomerNotFoundException("There is no user with id " + customerId);
        }
        customerRepository.deleteById(customerId);
    }
}
