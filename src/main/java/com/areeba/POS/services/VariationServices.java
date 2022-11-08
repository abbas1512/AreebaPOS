package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.VariationDTO;
import com.areeba.POS.entity.Variations;

import java.util.List;

public interface VariationServices {

    Variations createVariation(VariationDTO variationDTO);

    RestCommonResponse updateVariation(long Id, VariationDTO variationDTO);

    RestCommonResponse deleteVariation(long Id);

    RestCommonResponse saveVariation(VariationDTO variationDTO, String name);

    Variations findById(long Id);

    Variations findByName(String name);

    RestCommonResponse getAll();

}
