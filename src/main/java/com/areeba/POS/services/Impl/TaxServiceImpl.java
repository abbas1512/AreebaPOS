package com.areeba.POS.services.Impl;

import com.areeba.POS.dto.TaxDTO;
import com.areeba.POS.entity.Taxes;
import com.areeba.POS.repository.TaxRepository;
import com.areeba.POS.services.TaxServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TaxService")
public class TaxServiceImpl implements TaxServices {

    @Autowired
    TaxRepository taxRepository;

    @Override
    public void createTax(TaxDTO taxDTO) {
        Taxes tax = new Taxes();
        tax.setItemId(taxDTO.getItemId());
        tax.setName(taxDTO.getName());
        tax.setPercentage(taxDTO.getPercentage());
        taxRepository.save(tax);
    }

    @Override
    public void updateTax(TaxDTO taxDTO, long Id) {
        Taxes taxById = taxRepository.getById(Id);
        taxById.setItemId(taxDTO.getItemId());
        taxById.setName(taxDTO.getName());
        taxById.setPercentage(taxDTO.getPercentage());
        taxRepository.save(taxById);
    }

    @Override
    public void deleteTax(long Id) {
        taxRepository.deleteById(Id);
    }

    @Override
    public Taxes findById(long Id) {
        return taxRepository.getById(Id);
    }

    @Override
    public Taxes findByName(String name) {
        return taxRepository.findByName(name);
    }

    @Override
    public List<Taxes> getAll() {
        return taxRepository.findAll();
    }
}
