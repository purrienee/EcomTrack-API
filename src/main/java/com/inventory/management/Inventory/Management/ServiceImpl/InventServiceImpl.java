package com.inventory.management.Inventory.Management.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.Inventory.Management.DataModel.ProductEntitu;
import com.inventory.management.Inventory.Management.Respository.InventoryRepo;
import com.inventory.management.Inventory.Management.Services.InventService;
@Service
public class InventServiceImpl implements InventService {
    
    @Autowired
    private InventoryRepo repository; 

    public ProductEntitu createProduct(ProductEntitu product)
    {
        return repository.save(product);
    }

    @Override
    public ProductEntitu getProductById(Integer productId) {
        return repository.findByProductid(productId);
    }

    public ProductEntitu updateProduct(ProductEntitu product) {
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        repository.deleteById(productId);
    }
}
    

