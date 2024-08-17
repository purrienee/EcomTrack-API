package com.inventory.management.Inventory.Management.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.management.Inventory.Management.DataModel.ProductEntitu;
import org.springframework.stereotype.Repository;
@Repository
public interface InventoryRepo extends JpaRepository<ProductEntitu , Integer>  {

    ProductEntitu findByProductid(Integer productid);
    
}
