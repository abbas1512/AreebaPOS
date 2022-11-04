package com.areeba.POS.services;

import com.areeba.POS.dto.CustomerDTO;
import com.areeba.POS.entity.Customers;

import java.util.List;

public interface CustomerService {

    void createCustomer(CustomerDTO customerDTO) throws Exception;

    void updateCustomer(CustomerDTO customerDTO, long Id);

    void deleteCustomer(long Id);

    Customers findById(long Id);

    Customers findByName(String name);

    List<Customers> getAll();

}
