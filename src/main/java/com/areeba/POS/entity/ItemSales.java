package com.areeba.POS.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "itemSales")
public class ItemSales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Customers.class)
    @JoinColumn(name = "itemId", nullable = false, insertable = false, updatable = false)
    private Items itemId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Discounts.class)
    @JoinColumn(name = "saleId", nullable = false)
    private Sales saleId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "SKU", nullable = true)
    private String SKU;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public ItemSales(Items itemId, Sales saleId, String name, String SKU, BigDecimal price, int quantity) {
        this.itemId = itemId;
        this.saleId = saleId;
        this.name = name;
        this.SKU = SKU;
        this.price = price;
        this.quantity = quantity;
    }
}
