package com.areeba.pos.entity;

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
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Items.class, mappedBy = "categoryId")
    private Set<Items> itemId;

    @Column(name = "name", nullable = false)
    private String name;

    public Category(Set<Items> itemId, String name) {
        this.itemId = itemId;
        this.name = name;
    }
}
