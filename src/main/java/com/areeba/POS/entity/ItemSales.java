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

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public ItemSales(Items itemId, Sales saleId, int quantity) {
        this.itemId = itemId;
        this.saleId = saleId;
        this.quantity = quantity;
    }
}
