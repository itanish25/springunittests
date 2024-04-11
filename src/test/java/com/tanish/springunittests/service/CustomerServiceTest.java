package com.tanish.springunittests.service;

import com.tanish.springunittests.model.Customer;
import com.tanish.springunittests.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityNotFoundException;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testGetCustomer() throws Exception {
        Customer returned = new Customer(1L, "Tanish");

        Mockito.when(customerRepository.getOne(1L)).thenReturn(returned);

        Customer result = customerService.getCustomer(returned.getId());

        Assert.assertEquals("Tanish", result.getName());
    }

    @Test(expected = EntityNotFoundException.class)  // Need to research on this for more clearity
    public void testGetCustomer_notFound(){
        doThrow(new EntityNotFoundException()).when(customerRepository).getOne(1L);
        customerService.getCustomer(1L);
    }

    @Test
    public void testSaveCustomer(){
        Customer input = new Customer(1L, "Tanish");

        Mockito.when(customerRepository.save(input)).thenReturn(input);

        Customer result = customerService.saveCustomer(input);

        Assert.assertEquals(result.getName(), "Tanish");
    }

    @Test
    public void testUpdateCustomer() {
        Customer input = new Customer(1L, "Tanish");
        Customer returned = new Customer(1L, "Tanish_updated");

        Mockito.when(customerRepository.getOne(input.getId())).thenReturn(input);
        Mockito.when(customerRepository.save(input)).thenReturn(returned);

        Customer result = customerService.updateCustomer(input.getId(), input);

        Assert.assertEquals("Tanish_updated", result.getName());
    }

    @Test(expected = EntityNotFoundException.class)  // Need to research on this for more clearity
    public void testUpdateCustomer_notFound(){
        doThrow(new EntityNotFoundException()).when(customerRepository).getOne(1L);
        Customer input = new Customer(1L, "Tanish");
        customerService.updateCustomer(1L, input);
    }

    @Test
    public void testDeleteCustomer() throws Exception {      // IMPORTANT
        Customer input = new Customer(1L, "Tanish");

        Mockito.when(customerRepository.getOne(input.getId())).thenReturn(input);
        doNothing().when(customerRepository).delete(input);

        customerService.deleteCustomer(1L);
    }
}


























