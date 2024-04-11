package com.tanish.springunittests.controller;

import com.tanish.springunittests.model.Customer;
import com.tanish.springunittests.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void testGetCustomer() {
        Customer returned = new Customer(1L,"Tanish");
        String expected = "{id:1,name:Tanish}";

        Mockito.when(customerService.getCustomer(1L)).thenReturn(returned);

        Customer result = customerController.getCustomer(1L);

        Assert.assertEquals(result.getName(),"Tanish");
    }

    @Test
    public void testSaveCustomer() throws Exception {
        Customer input = new Customer(1L, "Tanish");
        Customer returned = new Customer(input.getId(), "Tanish");

        Mockito.when(customerService.saveCustomer(input)).thenReturn(returned);

        Customer result = customerController.saveCustomer(input);

        Assert.assertEquals(result.getName(), "Tanish");
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        Customer input = new Customer(1L, "Tanish");
        Customer returned = new Customer(1L, "Tanish_updated");

        Mockito.when(customerService.updateCustomer(input.getId(), input)).thenReturn(returned);

        Customer result = customerController.updateCustomer(1L, input);

        Assert.assertEquals(result.getName(), "Tanish_updated");
    }
}
