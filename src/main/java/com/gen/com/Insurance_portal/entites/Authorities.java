package com.gen.com.Insurance_portal.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String name;

    private String description;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "group_authorities_id")
    private GroupAuthorities groupAuthorities;

    public Authorities(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
