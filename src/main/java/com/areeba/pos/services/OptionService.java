package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.OptionDTO;
import com.areeba.pos.dto.OptionVariationDTO;
import com.areeba.pos.entity.OptionVariations;
import com.areeba.pos.entity.Options;

public interface OptionService {

    Options createOption(OptionDTO optionDTO);

    OptionVariations createVariation(OptionVariationDTO optionVariationDTO);

    RestCommonResponse updateOption(long Id, OptionDTO optionDTO);

    RestCommonResponse updateVariation(long Id, OptionVariationDTO optionVariationDTO);

    RestCommonResponse deleteOption(long Id);

    RestCommonResponse deleteVariation(long Id);

    RestCommonResponse saveOption(OptionDTO optionDTO, String name);

    RestCommonResponse saveVariation(OptionVariationDTO optionVariationDTO, String name);

    Options getOption(long optionId);

    Options getOptionName(String name);

    RestCommonResponse getAllOptions();

    OptionVariations getVariation(long variationId);

    OptionVariations getVariationName(String name);

    RestCommonResponse getAllVariations();

}
