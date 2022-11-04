package com.areeba.POS.services.Impl;

import com.areeba.POS.dto.VariationDTO;
import com.areeba.POS.entity.Variations;
import com.areeba.POS.repository.VariationRepository;
import com.areeba.POS.services.VariationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("VariationServices")
public class VariationServiceImpl implements VariationServices {

    @Autowired
    VariationRepository variationRepository;


    @Override
    public void createVariation(VariationDTO variationDTO) throws Exception {
        Variations variations = new Variations();
        variations.setItemId(variationDTO.getItemId());
        variations.setOptionVariationId(variationDTO.getOptionVariationId());
        variations.setName(variationDTO.getName());
        variations.setUnit(variationDTO.getUnit());
        variations.setPrice(variationDTO.getPrice());
        variations.setStock(variationDTO.getStock());
        variationRepository.save(variations);
    }

    @Override
    public void updateVariation(VariationDTO variationDTO, long Id) {
        Variations variationsById = variationRepository.findById(Id);
        variationsById.setItemId(variationDTO.getItemId());
        variationsById.setOptionVariationId(variationDTO.getOptionVariationId());
        variationsById.setName(variationDTO.getName());
        variationsById.setUnit(variationDTO.getUnit());
        variationsById.setPrice(variationDTO.getPrice());
        variationsById.setStock(variationDTO.getStock());
        variationRepository.save(variationsById);
    }

    @Override
    public void deleteVariation(long Id) {
        variationRepository.deleteById(Id);
    }

    @Override
    public Variations findById(long Id) {
        return variationRepository.findById(Id);
    }

    @Override
    public Variations findByName(String name) {
        return variationRepository.findByName(name);
    }

    @Override
    public List<Variations> getAll() {
        return variationRepository.findAll();
    }

}
