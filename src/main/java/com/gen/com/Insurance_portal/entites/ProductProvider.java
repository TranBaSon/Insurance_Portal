package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.ProductProviderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ProductProvider extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    protected String code;

    private String email;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 20)
    private String hotline;

    @Lob
    private String introductionContent;

    @Column(nullable = false)
    private ProductProviderStatus status;

    private String avatarImage;

    @Column(nullable = false)
    private String appellation;

    @Column(nullable = false)
    private String contact;

    @OneToMany(mappedBy = "productProvider", cascade = CascadeType.ALL)
    private Set<CustomerContactCode> customerContactCodes;
    private Boolean isActive;

}
