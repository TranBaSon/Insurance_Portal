package com.gen.com.Insurance_portal.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CarModel {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(unique = true)
    private String code;

    private Double price;

    @JsonIgnore
    @EqualsExclude
    @ToStringExclude
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(title, carModel.title) &&
                Objects.equals(code, carModel.code) &&
                Objects.equals(price, carModel.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, code, price);
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}
