package com.gen.com.Insurance_portal.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Data
@Entity
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carBrand;

    private String carBrandCode;

    @OneToMany(mappedBy = "carBrand", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CarModel> models = new HashSet<>();
}
