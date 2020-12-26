package com.gen.com.Insurance_portal.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Role extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(unique = true)
    private String name;

    private Boolean isDeleted;

    private Date deletedAt;

    @OneToMany
    private Set<Authorities> authoritiesSet;

    public Role(String description, String name) {
        this.description = description;
        this.name = name;
    }
}
