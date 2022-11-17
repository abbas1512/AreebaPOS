package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.VariationDTO;
import com.areeba.pos.entity.Variations;


public interface VariationServices {

    Variations createVariation(VariationDTO variationDTO);

    RestCommonResponse updateVariation(long Id, VariationDTO variationDTO);

    RestCommonResponse deleteVariation(long Id);

    RestCommonResponse saveVariation(VariationDTO variationDTO, String name);

    Variations findById(long Id);

    Variations findByName(String name);

    RestCommonResponse getAll();

}
