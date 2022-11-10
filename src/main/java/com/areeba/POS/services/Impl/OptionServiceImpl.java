package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.OptionDTO;
import com.areeba.POS.dto.OptionVariationDTO;
import com.areeba.POS.dto.VariationDTO;
import com.areeba.POS.entity.*;
import com.areeba.POS.repository.OptionRepository;
import com.areeba.POS.repository.OptionVariationRepository;
import com.areeba.POS.services.OptionService;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service("OptionService")
public class OptionServiceImpl implements OptionService {

    @Autowired
    private final OptionRepository optionRepository;
    @Autowired
    private final OptionVariationRepository optionVariationRepository;

    private static final Logger log = (Logger) LoggerFactory.getLogger(OptionServiceImpl.class);

    public OptionServiceImpl(OptionRepository optionRepository, OptionVariationRepository optionVariationRepository) {
        this.optionRepository = optionRepository;
        this.optionVariationRepository = optionVariationRepository;
    }

    @Override
    public Options createOption(OptionDTO optionDTO){
        Options options = new Options();
        options.setOptionVariationId(optionDTO.getOptionVariationId());
        options.setName(optionDTO.getName());
        return optionRepository.save(options);
    }

    @Override
    public OptionVariations createVariation(OptionVariationDTO optionVariationDTO) {
        OptionVariations optionVariation = new OptionVariations();
        optionVariation.setVariationId(optionVariationDTO.getVariationId());
        optionVariation.setOptionId(optionVariation.getOptionId());
        optionVariation.setName(optionVariation.getName());
        return optionVariationRepository.save(optionVariation);
    }

    @Override
    public RestCommonResponse updateOption(long Id, OptionDTO optionDTO) {
        if (this.optionRepository.findById(Id) != null) {
            Options optionById = this.optionRepository.findById(Id);
            optionById.setOptionVariationId(optionDTO.getOptionVariationId());
            optionById.setName(optionById.getName());
            Options updatedOption = this.optionRepository.save(optionById);
            return new RestCommonResponse(true, new Options(
                    updatedOption.getOptionVariationId(),
                    updatedOption.getName()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse updateVariation(long Id, OptionVariationDTO optionVariationDTO) {
        if (this.optionVariationRepository.findById(Id) != null) {
            OptionVariations variationById = this.optionVariationRepository.findById(Id);
            variationById.setOptionId(optionVariationDTO.getOptionId());
            variationById.setVariationId(optionVariationDTO.getVariationId());
            variationById.setName(optionVariationDTO.getName());
            OptionVariations updatedVariation = this.optionVariationRepository.save(variationById);
            return new RestCommonResponse(true, new OptionVariations(
                    (Set<Variations>) updatedVariation.getOptionId(),
                    (Options) updatedVariation.getVariationId(),
                    updatedVariation.getName()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse deleteOption(long Id) {
        if (this.optionRepository.findById(Id) != null) {
            this.optionRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse deleteVariation(long Id) {
        if (this.optionVariationRepository.findById(Id) != null) {
            this.optionVariationRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse saveOption(OptionDTO optionDTO, String name) {
        Options options = this.optionRepository.findByName(name);
        if (options == null) {
            log.info("Saving discount to the database");
            return new RestCommonResponse(true, this.optionRepository.save(options));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public RestCommonResponse saveVariation(OptionVariationDTO optionVariationDTO, String name) {
        OptionVariations optionVariations = this.optionVariationRepository.findByName(name);
        if (optionVariations == null) {
            log.info("Saving discount to the database");
            return new RestCommonResponse(true, this.optionVariationRepository.save(optionVariations));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public Options getOption(long optionId) {
        log.info("Fetching Option");
        return this.optionRepository.findById(optionId);
    }

    @Override
    public Options getOptionName(String name) {
        log.info("Fetching Option");
        return this.optionRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAllOptions() {
        log.info("Fetching All Options");
        List<Options> options = this.optionRepository.findAll();
        return new RestCommonResponse(true, options);
    }

    @Override
    public OptionVariations getVariation(long variationId) {
        log.info("Fetching Variation");
        return this.optionVariationRepository.findById(variationId);
    }

    @Override
    public OptionVariations getVariationName(String name) {
        log.info("Fetching Variation");
        return this.optionVariationRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAllVariations() {
        log.info("Fetching All Variation");
        List<OptionVariations> optionVariations = this.optionVariationRepository.findAll();
        return new RestCommonResponse(true, optionVariations);
    }
}
