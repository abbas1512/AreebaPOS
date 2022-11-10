package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.OptionDTO;
import com.areeba.POS.dto.OptionVariationDTO;
import com.areeba.POS.dto.VariationDTO;
import com.areeba.POS.entity.OptionVariations;
import com.areeba.POS.entity.Options;

import java.util.List;

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
