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
@Table(name = "optionVariations")
public class OptionVariations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Variations.class, mappedBy = "optionVariationId")
    private Set<Variations> variationId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Options.class)
    @JoinColumn(name = "optionId", nullable = false)
    private Options optionId;

    @Column(name = "name", nullable = false)
    private String name;

    public OptionVariations(Set<Variations> variationId, Options optionId, String name) {
        this.variationId = variationId;
        this.optionId = optionId;
        this.name = name;
    }
}