package com.areeba.pos.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customers")
public class Customers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Sales.class, mappedBy = "customerId")
    private Set<Sales> saleId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "company", nullable = true)
    private String company;

    @Column(name = "birthday", nullable = true)
    private Date birthday;

    private String name = firstName + " " + lastName;

    public Customers(Set<Sales> saleId, String name, String phoneNumber,
                     String email, String address, String company, Date birthday) {
        this.saleId = saleId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.company = company;
        this.birthday = birthday;
        this.name = name;
    }
}
