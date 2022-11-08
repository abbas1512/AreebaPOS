package com.areeba.POS.entity;

import com.areeba.POS.enums.Type;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "discount")
public class Discounts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Discounts.class)
    private Sales saleId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private Type type;

    @Column(name = "amount", nullable = false)
    private double amount;

    public Discounts(Sales saleId, String name, Type type, double amount) {
        this.saleId = saleId;
        this.name = name;
        this.type = type;
        this.amount = amount;
    }
}
