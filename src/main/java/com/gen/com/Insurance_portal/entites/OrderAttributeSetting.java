package com.gen.com.Insurance_portal.entites;

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
public class OrderAttributeSetting extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_attribute_id")
    private ProductAttribute productAttribute;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    /*

        public Guid ProductAttributeId { get; set; }
        public int? ProductAttributeOptionId { get; set; }

        public ProductAttribute ProductAttribute { get; set; }

        public string StringValue { get; set; }
        public DateTime DateTimeValue { get; set; }
        public decimal NumberValue { get; set; }
        public bool BoolValue { get; set; }

        [ForeignKey("ProductAttributeOptionId")]
        public ProductAttributeOption ProductAttributeOption { get; set; }

    */
}
