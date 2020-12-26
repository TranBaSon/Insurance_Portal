package com.gen.com.Insurance_portal.entites;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Article extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String shortDescription;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date postDate;

    private String articleImage;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "article_category_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ArticleCategory articleCategory;

}
