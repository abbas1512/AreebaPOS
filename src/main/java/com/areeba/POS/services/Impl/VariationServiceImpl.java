package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.VariationDTO;
import com.areeba.POS.entity.Variations;
import com.areeba.POS.repository.VariationRepository;
import com.areeba.POS.services.VariationServices;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.logging.Logger;

@Service("VariationServices")
public class VariationServiceImpl implements VariationServices {

    @Autowired
    private final VariationRepository variationRepository;

    private static final Logger log = (Logger) LoggerFactory.getLogger(VariationServiceImpl.class);

    public VariationServiceImpl(VariationRepository variationRepository) {
        this.variationRepository = variationRepository;
    }

    @Override
    public Variations createVariation(VariationDTO variationDTO) {
        Variations variations = new Variations();
        variations.setItemId(variationDTO.getItemId());
        variations.setOptionVariationId(variationDTO.getOptionVariationId());
        variations.setName(variationDTO.getName());
        variations.setUnit(variationDTO.getUnit());
        variations.setPrice(variationDTO.getPrice());
        variations.setStock(variationDTO.getStock());
        return variationRepository.save(variations);
    }

    @Override
    public RestCommonResponse updateVariation(long Id, VariationDTO variationDTO) {
        if (this.variationRepository.findById(Id) != null) {
            Variations variationById = this.variationRepository.findById(Id);
            variationById.setItemId(variationDTO.getItemId());
            variationById.setOptionVariationId(variationDTO.getOptionVariationId());
            variationById.setName(variationDTO.getName());
            variationById.setUnit(variationDTO.getUnit());
            variationById.setPrice(variationDTO.getPrice());
            variationById.setStock(variationDTO.getStock());
            Variations updatedVariation = this.variationRepository.save(variationById);
            return new RestCommonResponse(true, new Variations(
                    updatedVariation.getItemId(),
                    updatedVariation.getOptionVariationId(),
                    updatedVariation.getName(),
                    updatedVariation.getUnit(),
                    updatedVariation.getPrice(),
                    updatedVariation.getStock()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public RestCommonResponse deleteVariation(long Id) {
        if (this.variationRepository.findById(Id) != null) {
            this.variationRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public RestCommonResponse saveVariation(VariationDTO variationDTO, String name) {
        Variations variations = this.variationRepository.findByName(name);
        if (variations == null) {
            log.info("Saving variation to the database");
            return new RestCommonResponse(true, this.variationRepository.save(variations));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public Variations findById(long Id) {
        log.info("Fetching Variation");
        return this.variationRepository.findById(Id);
    }

    @Override
    public Variations findByName(String name) {
        log.info("Fetching Variation");
        return this.variationRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAll() {
        log.info("Fetching All Variations");
        List<Variations> variations = this.variationRepository.findAll();
        return new RestCommonResponse(true, variations);
    }
}
