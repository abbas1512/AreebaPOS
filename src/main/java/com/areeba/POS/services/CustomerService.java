package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.CustomerDTO;
import com.areeba.POS.entity.Customers;

import java.util.List;

public interface CustomerService {
    Customers createCustomer(CustomerDTO customerDTO);

    RestCommonResponse updateCustomer(long Id, CustomerDTO customerDTO);

    RestCommonResponse deleteCustomer(long Id);

    RestCommonResponse saveCustomer(CustomerDTO customerDTO, String name);

    Customers findById(long Id);

    Customers findByName(String name);

    RestCommonResponse getAll();

}
