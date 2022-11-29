package com.areeba.pos.services.Impl;

import com.areeba.pos.common.ErrorResponseApisEnum;
import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CartDTO;
import com.areeba.pos.dto.SaleDTO;
import com.areeba.pos.entity.Cart;
import com.areeba.pos.entity.Customers;
import com.areeba.pos.entity.Sales;
import com.areeba.pos.repository.*;
import com.areeba.pos.services.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Set;

@Service("SaleService")
public class SaleServiceImpl implements SaleService {

    @Autowired
    private final SaleRepository saleRepository;
    @Autowired
    private final CartRepository cartRepository;
    @Autowired
    private final ItemRepository itemRepository;
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final DiscountRepository discountRepository;
    private final Logger log = LoggerFactory.getLogger(SaleServiceImpl.class);

    public SaleServiceImpl(SaleRepository saleRepository, CartRepository cartRepository,
                           ItemRepository itemRepository, CustomerRepository customerRepository,
                           DiscountRepository discountRepository) {
        this.saleRepository = saleRepository;
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
    }

    @Override
    public Cart addItem(CartDTO cartDTO) {
        Cart cart = new Cart();
        cart.setItemId(itemRepository.findById(cartDTO.getItemId()));
        cart.setQuantity(cartDTO.getQuantity());
        cart.setItemTotal(cartDTO.getItemTotal());
        return cartRepository.save(cart);
    }

    @Override
    public RestCommonResponse removeItem(long cartId) {
        if (this.cartRepository.findById(cartId) != null) {
            this.cartRepository.deleteById(cartId);
            return new RestCommonResponse(true, "Removed");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.ItemNotFound)));
        }
    }

    @Override
    public Sales createSale(SaleDTO saleDTO) {
        Sales sale = new Sales();
        sale.setCustomerId(customerRepository.findById(saleDTO.getCustomerId()));
        sale.setCartId(cartRepository.findById(saleDTO.getCartId()));
        sale.setDiscountsId(saleDTO.getDiscountsId());
        sale.setNotes(saleDTO.getNotes());
        sale.setPaymentType(saleDTO.getPaymentType());
        sale.setSubtotal(saleDTO.getSubtotal());
        sale.setTotal(saleDTO.getTotal());
        sale.setDate(saleDTO.getDate());
        return saleRepository.save(sale);
    }

    @Override
    public RestCommonResponse cancelSale(long id) {
        if (this.saleRepository.findById(id) != null) {
            this.saleRepository.deleteById(id);
            return new RestCommonResponse(true, "Cancelled");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesNotExist)));
        }
    }

    @Override
    public Sales getSale(long id) {
        log.info("Fetching Sale");
        return this.saleRepository.findById(id);
    }

    @Override
    public Cart viewCart(long id) {
        log.info("Fetching Cart");
        return (Cart) this.cartRepository.findById(id);
    }

    @Override
    public RestCommonResponse getAllSales() {
        log.info("Fetching All Sales");
        List<Sales> sales = this.saleRepository.findAll();
        return new RestCommonResponse(true, sales);
    }
}
