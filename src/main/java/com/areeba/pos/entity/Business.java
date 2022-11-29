package com.areeba.pos.entity;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

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
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User userId;

    @OneToMany(mappedBy = "businessId")
    private Set<Items> itemId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    public Business(User userId, Set<Items> itemId, String name, String firstName, String lastName,
                    String type, String category, String address, String city, String postalCode) {
        this.userId = userId;
        this.itemId = itemId;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.category = category;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }
}
