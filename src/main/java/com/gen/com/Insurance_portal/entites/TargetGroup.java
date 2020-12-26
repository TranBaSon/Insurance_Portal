package com.gen.com.Insurance_portal.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class TargetGroup extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Lob
    @Column(nullable = false)
    private String description;

    private Boolean isActive;

    @Column(name = "`index`")
    private Integer index;

// cant use
//    @OneToMany(mappedBy = "targetGroup")
//    private Set<Product> products;

}
