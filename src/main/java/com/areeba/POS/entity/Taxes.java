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
@Table(name = "taxes")
public class Taxes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Business.class)
    @JoinColumn(name = "item_id", nullable = true)
    private Items itemId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "percentage", nullable = false)
    private BigDecimal percentage;

}
