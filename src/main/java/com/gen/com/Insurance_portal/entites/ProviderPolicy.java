package com.gen.com.Insurance_portal.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ProviderPolicy extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberPolicy;

    private Date effectiveFrom;

    private Date effectiveTo;

    @ManyToOne
    @JoinColumn(name = "product_provider_id")
    private ProductProvider productProvider;

}
