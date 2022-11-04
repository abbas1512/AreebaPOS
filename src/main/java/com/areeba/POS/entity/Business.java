package com.areeba.POS.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "business")
public class Business implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Items.class, mappedBy = "businessId")
    private Set<Items> itemId;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "postalCode", nullable = false)
    private String postalCode;

}
