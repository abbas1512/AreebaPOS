package com.areeba.POS.entity;

import com.areeba.POS.enums.PaymentType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sales")
public class Sales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ItemSales.class, mappedBy = "saleId")
    private Set<ItemSales> itemSaleId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Customers.class)
    @JoinColumn(name = "customerId", nullable = false)
    private Customers customerId;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Discounts.class, mappedBy = "saleId")
    private Set<Discounts> discountsId;

    @Column(name = "notes", nullable = true)
    private String notes;

    @Column(name = "paymentType", nullable = false)
    private PaymentType paymentType;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "date", nullable = false)
    private Date date;

}
