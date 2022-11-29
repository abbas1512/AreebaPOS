package com.areeba.pos.entity;

import com.areeba.pos.enums.Unit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Business.class)
    @JoinColumn(name = "business_id", nullable = false)
    @JsonIgnore
    private Business businessId;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Taxes.class, mappedBy = "itemId")
    private Set<Taxes> taxId;

    @Column(name = "category")
    private String category;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = true)
    private Blob image;

    @Column(name = "SKU", nullable = true)
    private String SKU;

    @Column(name = "unit", nullable = false)
    private Unit unit;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "stock", nullable = false)
    private int stock;

    public Items(Business businessId, Set<Taxes> taxId, String category,
                 String name, Blob image, String SKU, Unit unit, float price, int stock) {
        this.businessId = businessId;
        this.taxId = taxId;
        this.category = category;
        this.name = name;
        this.image = image;
        this.SKU = SKU;
        this.unit = unit;
        this.price = price;
        this.stock = stock;
    }

}
