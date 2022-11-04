package com.areeba.POS.services;

import com.areeba.POS.dto.OptionDTO;
import com.areeba.POS.dto.OptionVariationDTO;
import com.areeba.POS.entity.OptionVariations;
import com.areeba.POS.entity.Options;

import java.util.List;

public interface OptionService {

    void createOption(OptionDTO optionDTO) throws Exception;

    void updateOption(OptionDTO optionDTO, long Id);

    void deleteOption(long Id);

    Options findById(long Id);

    Options findByName(String name);

    List<Options> getAll();

    void createOptionVariation(OptionVariationDTO optionVariationDTO) throws Exception;

    void updateOptionVariation(OptionVariationDTO optionVariationDTO, long Id);

    void deleteOptionVariation(long Id);

    OptionVariations findOptionVariationById(long Id);

    OptionVariations findOptionVariationByName(String name);

    List<OptionVariations> getAllOptionVariations();

}
