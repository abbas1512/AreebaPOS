package com.areeba.pos.entity;

import com.areeba.pos.enums.Type;
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
    @Column(name = "id")
    private long id;

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
