package com.areeba.POS.entity;

import com.areeba.POS.dto.VariationDTO;
import com.areeba.POS.enums.Unit;
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
@Table(name = "variations")
public class Variations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Items.class)
    private Items itemId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = OptionVariations.class)
    @JoinColumn(name = "optionVariationId")
    private OptionVariations optionVariationId;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit", nullable = false)
    private Unit unit;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private int stock;

    public Variations(Items itemId, OptionVariations optionVariationId, String name, Unit unit, BigDecimal price, int stock) {
        this.itemId = itemId;
        this.optionVariationId = optionVariationId;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.stock = stock;
    }
}
