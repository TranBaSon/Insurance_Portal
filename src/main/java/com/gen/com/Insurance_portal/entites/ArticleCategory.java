package com.gen.com.Insurance_portal.entites;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ArticleCategory extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String shortDescription;

    @OneToMany(mappedBy = "articleCategory")
    private Set<Article> articles;
}
