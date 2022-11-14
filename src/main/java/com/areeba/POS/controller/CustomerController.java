package com.areeba.POS.controller;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.CustomerDTO;
import com.areeba.POS.entity.Customers;
import com.areeba.POS.services.CustomerService;
import com.areeba.POS.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/customer"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class CustomerController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final CategoryServiceImpl categoryServiceImpl;

    public CustomerController(AuthenticationManager authenticationManager, CustomerService customerService, CategoryServiceImpl categoryServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.customerService = customerService;
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping
    public Customers getCustomer(long Id) {
        return this.customerService.findById(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllCustomers() {
        return this.customerService.getAll();
    }

    @GetMapping({"/name"})
    public Customers getCustomerName(String name) {
        return this.customerService.findByName(name);
    }

    @GetMapping({"/create"})
    public Customers createCustomer(CustomerDTO customerDTO) {
        return this.customerService.createCustomer(customerDTO);
    }

    @PutMapping(value = {"/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateCustomer(@PathVariable("Id") long Id, @RequestBody CustomerDTO customerDTO) {
        return this.customerService.updateCustomer(Id, customerDTO);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse deleteCustomer(@PathVariable("Id") long Id) {
        return this.customerService.deleteCustomer(Id);
    }

    @PostMapping({"/save"})
    public RestCommonResponse saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return this.customerService.saveCustomer(customerDTO, customerDTO.getName());
    }
}
