package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.SysAdminType;
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
public class SysAdmin extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private SysAdminType type;

    @OneToOne
    @JoinColumn(name = "product_provider_id")
    private ProductProvider productProvider;

    private Boolean isActive;

}
