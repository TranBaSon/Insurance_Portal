package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.ProductProviderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ProviderHistory extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String approvedBy;

    @OneToOne
    @JoinColumn(name = "provider_policy_id")
    private ProviderPolicy providerPolicy;

    @ManyToOne
    @JoinColumn(name = "product_provider_id")
    private ProductProvider productProvider;

    private ProductProviderStatus productProviderStatus;
}
