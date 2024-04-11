package com.tanish.springunittests.controller;

import com.tanish.springunittests.model.Customer;
import com.tanish.springunittests.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/get/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "/save/customer", method = RequestMethod.POST)
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @RequestMapping(value = "/update/customer/{id}", method = RequestMethod.PUT)
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }

    @RequestMapping(value = "/delete/customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
}
