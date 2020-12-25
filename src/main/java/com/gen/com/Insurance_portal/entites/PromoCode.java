package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.PromoCodeStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PromoCode extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private PromoCodeStatus promoCodeStatus;

    public String msisdn; //Mobile Station Integrated Services Digital Network là một số xác định duy nhất một thuê bao trong Hệ thống thông tin di động toàn cầu hoặc Mạng di động của Hệ thống viễn thông di động toàn cầu

    private Date issueDate;

    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Date startDate;

    private Date endDate;

}
