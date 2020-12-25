package com.gen.com.Insurance_portal.entites;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class CustomerContactCode extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_provider_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ProductProvider productProvider;

    private String contactCode;

}
