package com.areeba.POS.services.Impl;

import com.areeba.POS.dto.CustomerDTO;
import com.areeba.POS.entity.Customers;
import com.areeba.POS.repository.CustomerRepository;
import com.areeba.POS.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerDTO customerDTO) throws Exception {
        Customers customer = new Customers();
        customer.setSaleId(customerDTO.getSaleId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        customer.setCompany(customerDTO.getCompany());
        customer.setBirthday(customerDTO.getBirthday());
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO, long Id) {
        Customers customerById = customerRepository.findById(Id);
        customerById.setSaleId(customerDTO.getSaleId());
        customerById.setFirstName(customerDTO.getFirstName());
        customerById.setLastName(customerDTO.getLastName());
        customerById.setPhoneNumber(customerDTO.getPhoneNumber());
        customerById.setEmail(customerDTO.getEmail());
        customerById.setAddress(customerDTO.getAddress());
        customerById.setCompany(customerDTO.getCompany());
        customerById.setBirthday(customerDTO.getBirthday());
        customerRepository.save(customerById);
    }

    @Override
    public void deleteCustomer(long Id) {
        customerRepository.deleteById(Id);
    }

    @Override
    public Customers findById(long Id) {
        return customerRepository.findById(Id);
    }

    @Override
    public Customers findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public List<Customers> getAll() {
        return customerRepository.findAll();
    }
}
