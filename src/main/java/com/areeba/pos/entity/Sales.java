package com.areeba.pos.entity;

import com.areeba.pos.enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Cart.class, mappedBy = "saleId")
    private Set<Cart> cartId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Customers.class)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customers customerId;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Discounts.class, mappedBy = "saleId")
    @ToString.Exclude
    private Set<Discounts> discountsId;

    @Column(name = "notes", nullable = true)
    private String notes;

    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    @Column(name = "subtotal", insertable = false)
    @JsonIgnore
    private Double subtotal;

    @Column(name = "total" , insertable = false)
    @JsonIgnore
    private Double total;

    @Column(name = "date", nullable = true)
    private Date date;

    public Double getSubtotal() {
        return subtotal = cartId.stream().filter(o -> o.getItemTotal() > 10).mapToDouble(Cart::getItemTotal).sum();
    }

    public Double getTotal() {
        return total = subtotal * discountsId.stream().filter(o -> o.getAmount() > 10).mapToDouble(Discounts::getAmount).sum();
    }

    public Sales(Set<Cart> cartId, Customers customerId, Set<Discounts> discountsId,
                 String notes, PaymentType paymentType, Double subtotal, Double total, Date date) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.discountsId = discountsId;
        this.notes = notes;
        this.paymentType = paymentType;
        this.subtotal = subtotal;
        this.total = total;
        this.date = date;
    }

}
