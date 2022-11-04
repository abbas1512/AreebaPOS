package com.areeba.POS.services;

import com.areeba.POS.dto.VariationDTO;
import com.areeba.POS.entity.Variations;

import java.util.List;

public interface VariationServices {

    void createVariation(VariationDTO variationDTO) throws Exception;

    void updateVariation(VariationDTO variationDTO, long Id);

    void deleteVariation(long Id);

    Variations findById(long Id);

    Variations findByName(String name);

    List<Variations> getAll();

}
