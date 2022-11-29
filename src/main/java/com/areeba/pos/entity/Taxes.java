package com.areeba.pos.entity;

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
@Table(name = "taxes")
public class Taxes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Business.class)
    @JoinColumn(name = "itemId", nullable = true)
    private Items itemId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "percentage", nullable = false)
    private BigDecimal percentage;

    public Taxes(Items itemId, String name, BigDecimal percentage) {
        this.itemId = itemId;
        this.name = name;
        this.percentage = percentage;
    }
}
