package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.ItemSaleDTO;
import com.areeba.POS.dto.SaleDTO;
import com.areeba.POS.entity.ItemSales;
import com.areeba.POS.entity.Sales;
import com.areeba.POS.repository.ItemSalesRepository;
import com.areeba.POS.repository.SaleRepository;
import com.areeba.POS.services.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;

@Service("SaleService")
public class SaleServiceImpl implements SaleService {

    @Autowired
    private final SaleRepository saleRepository;
    @Autowired
    private final ItemSalesRepository itemSalesRepository;
    private final Logger log = LoggerFactory.getLogger(SaleServiceImpl.class);

    public SaleServiceImpl(SaleRepository saleRepository, ItemSalesRepository itemSalesRepository) {
        this.saleRepository = saleRepository;
        this.itemSalesRepository = itemSalesRepository;
    }

    @Override
    public ItemSales addItem(ItemSaleDTO itemSaleDTO) {
        ItemSales itemSale = new ItemSales();
        itemSale.setItemId(itemSaleDTO.getItemId());
        itemSale.setSaleId(itemSaleDTO.getSaleId());
        itemSale.setQuantity(itemSaleDTO.getQuantity());
        return itemSalesRepository.save(itemSale);
    }

    @Override
    public RestCommonResponse removeItem(long Id) {
        if (this.itemSalesRepository.findById(Id) != null) {
            this.itemSalesRepository.deleteById(Id);
            return new RestCommonResponse(true, "Removed");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.ItemNotFound)));
        }
    }

    @Override
    public Sales createSale(SaleDTO saleDTO) {
        Sales sale = new Sales();
        sale.setItemSaleId(saleDTO.getItemSaleId());
        sale.setCustomerId(saleDTO.getCustomerId());
        sale.setDiscountsId(saleDTO.getDiscountsId());
        sale.setNotes(saleDTO.getNotes());
        sale.setPaymentType(saleDTO.getPaymentType());
        sale.setSubtotal(sale.getSubtotal());
        sale.setTotal(sale.getTotal());
        sale.setDate(saleDTO.getDate());
        return saleRepository.save(sale);
    }

    @Override
    public RestCommonResponse cancelSale(long Id) {
        if (this.saleRepository.findById(Id) != null) {
            this.saleRepository.deleteById(Id);
            return new RestCommonResponse(true, "Cancelled");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public RestCommonResponse confirmSale(SaleDTO saleDTO, long Id) {
        Sales sale = this.saleRepository.findById(Id);
        if (sale == null) {
            log.info("Sale has been confirmed");
            return new RestCommonResponse(true, this.saleRepository.save(sale));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public Sales getSale(long Id) {
        log.info("Fetching Sale");
        return this.saleRepository.findById(Id);
    }

    @Override
    public RestCommonResponse getAllSales() {
        log.info("Fetching All Sales");
        List<Sales> sales = this.saleRepository.findAll();
        return new RestCommonResponse(true, sales);
    }
}
