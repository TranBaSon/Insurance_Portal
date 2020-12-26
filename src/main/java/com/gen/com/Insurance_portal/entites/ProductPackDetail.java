package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.AutoExtendMethod;
import com.gen.com.Insurance_portal.common.enums.CycleType;
import com.gen.com.Insurance_portal.common.enums.PaymentMethod;
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
public class ProductPackDetail extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double cyclePrice;

    private Boolean isActive;

    @Column(nullable = false)
    private AutoExtendMethod autoExtendMethodCycle;

    @Column(nullable = false)
    private CycleType type;

    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "product_pack_id")
    private ProductPack productPack;

    @OneToMany(mappedBy = "productPackDetail")
    private Set<ProductPackDetailPayment> productPackDetailPayments;

    /*
        [Required]
        public string GeneratedUrl { get; set; }

        [Required]
        public string GeneratedRegistrationSMSSyntax { get; set; }

        [Required]
        public string GeneratedCancellationSMSSyntax { get; set; }
    */
}
