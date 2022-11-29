package com.areeba.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(targetEntity = Items.class)
    @JoinColumn(name = "item_id", nullable = true)
    @JsonIgnore
    private Items itemId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Sales.class)
    @JoinColumn(name = "saleId", nullable = false)
    private Sales saleId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "item_total", insertable = false)
    private Double itemTotal;

    public Double getItemTotal() {
        return itemTotal = (double) (itemId.getPrice() * quantity);
    }

    public Cart(Items itemId, int quantity, Double itemTotal) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
    }
}
