package com.areeba.pos.entity;

import com.areeba.pos.enums.Unit;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "items")
public class Items implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Taxes.class, mappedBy = "itemId")
    private Set<Taxes> taxId;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ItemSales.class, mappedBy = "itemId")
    private Set<ItemSales> itemSaleId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Business.class)
    @JoinColumn(name = "businessId", nullable = false)
    private Business businessId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Category.class)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category categoryId;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Variations.class , mappedBy = "itemId")
    private Set<Variations> variationId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = true)
    private Blob image;

    @Column(name = "SKU", nullable = true)
    private String SKU;

    @Column(name = "unit", nullable = false)
    private Unit unit;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private int stock;

    public Items(Business businessId, Category categoryId, Set<Variations> variationId, Set<Taxes> taxId,
                 Set<ItemSales> itemSaleId, String name, Blob image, String SKU, Unit unit, BigDecimal price, int stock) {
        this.businessId = businessId;
        this.categoryId = categoryId;
        this.variationId = variationId;
        this.taxId = taxId;
        this.itemSaleId = itemSaleId;
        this.name = name;
        this.image = image;
        this.SKU = SKU;
        this.unit = unit;
        this.price = price;
        this.stock = stock;
    }
}
