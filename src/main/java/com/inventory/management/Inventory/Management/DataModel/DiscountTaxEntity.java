package com.inventory.management.Inventory.Management.DataModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "discount_tax")
public class DiscountTaxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productid")
    private ProductEntitu product;

    private Double discountPercentage;
    private Double taxPercentage;
}
