package com.inventory.management.Inventory.Management.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.management.Inventory.Management.DataModel.DiscountTaxEntity;

@Repository
public interface DiscountTaxRepositpry extends JpaRepository<DiscountTaxEntity, Integer> {
    DiscountTaxEntity findByProduct_Productid(Integer productId);
}
