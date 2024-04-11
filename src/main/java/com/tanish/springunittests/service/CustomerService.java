package com.tanish.springunittests.service;

import com.tanish.springunittests.model.Customer;
import com.tanish.springunittests.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(Long id){
        Customer result = customerRepository.getOne(id);
        if(result == null)
            throw new EntityNotFoundException();
        return result;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Customer result = customerRepository.getOne(id);
        if(result == null)
            throw new EntityNotFoundException();
        result.setName(customer.getName());
        return customerRepository.save(result);
    }

    public void deleteCustomer(Long id){
        Customer result = customerRepository.getOne(id);
        if(result == null)
            throw new EntityNotFoundException();
        customerRepository.delete(result);
    }
}
