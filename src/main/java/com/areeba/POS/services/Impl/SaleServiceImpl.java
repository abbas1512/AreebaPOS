package com.areeba.POS.services.Impl;

import com.areeba.POS.dto.ItemSaleDTO;
import com.areeba.POS.dto.SaleDTO;
import com.areeba.POS.entity.ItemSales;
import com.areeba.POS.entity.Sales;
import com.areeba.POS.repository.ItemSalesRepository;
import com.areeba.POS.repository.SaleRepository;
import com.areeba.POS.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SaleService")
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ItemSalesRepository itemSalesRepository;

    @Override
    public void createSale(SaleDTO saleDTO) {
        Sales sale = new Sales();
        sale.setItemSaleId(saleDTO.getItemSaleId());
        sale.setCustomerId(saleDTO.getCustomerId());
        sale.setDiscountsId(saleDTO.getDiscountsId());
        sale.setNotes(saleDTO.getNotes());
        sale.setPaymentType(saleDTO.getPaymentType());
        sale.setSubtotal(saleDTO.getSubtotal());
        sale.setTotal(saleDTO.getTotal());
        sale.setDate(saleDTO.getDate());
        saleRepository.save(sale);
    }

    @Override
    public void createItemSale(ItemSaleDTO itemSaleDTO) {
        ItemSales itemSale = new ItemSales();
        itemSale.setItemId(itemSaleDTO.getItemId());
        itemSale.setSaleId(itemSaleDTO.getSaleId());
        itemSale.setName(itemSaleDTO.getName());
        itemSale.setSKU(itemSaleDTO.getSKU());
        itemSale.setPrice(itemSaleDTO.getPrice());
        itemSale.setQuantity(itemSaleDTO.getQuantity());
        itemSalesRepository.save(itemSale);
    }

    @Override
    public void deleteSale(long Id) {
        saleRepository.deleteById(Id);
    }

    @Override
    public void deleteItemSale(long Id) {
        itemSalesRepository.deleteById(Id);
    }

    @Override
    public Sales findById(long Id) {
        return saleRepository.getById(Id);
    }

    @Override
    public List<Sales> getAll() {
        return saleRepository.findAll();
    }
}
