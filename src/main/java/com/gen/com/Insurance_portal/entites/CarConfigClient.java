package com.gen.com.Insurance_portal.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CarConfigClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carConfigBannerFile;

    private String carConfigHeaderContent;

    private String carConfigBodyContent;

    public CarConfigClient(String carConfigBannerFile, String carConfigHeaderContent, String carConfigBodyContent) {
        this.carConfigBannerFile = carConfigBannerFile;
        this.carConfigHeaderContent = carConfigHeaderContent;
        this.carConfigBodyContent = carConfigBodyContent;
    }
}
