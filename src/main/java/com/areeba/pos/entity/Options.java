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
@Table(name = "options")
public class Options implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = OptionVariations.class, mappedBy = "optionId")
    private Set<OptionVariations> optionVariationId;

    @Column(name = "name", nullable = false)
    private String name;

    public Options(Set<OptionVariations> optionVariationId, String name) {
        this.optionVariationId = optionVariationId;
        this.name = name;
    }
}
