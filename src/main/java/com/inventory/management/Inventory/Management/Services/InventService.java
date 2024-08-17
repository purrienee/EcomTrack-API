package com.inventory.management.Inventory.Management.Services;

import com.inventory.management.Inventory.Management.DataModel.ProductEntitu;

public interface InventService {
    ProductEntitu createProduct(ProductEntitu product);
    ProductEntitu getProductById(Integer productId);
    ProductEntitu updateProduct(ProductEntitu product);
    void deleteProduct(Integer productId);
    
}
