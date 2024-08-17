package com.inventory.management.Inventory.Management.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.Inventory.Management.DataModel.DiscountTaxEntity;
import com.inventory.management.Inventory.Management.DataModel.ProductEntitu;
import com.inventory.management.Inventory.Management.Respository.DiscountTaxRepositpry;
import com.inventory.management.Inventory.Management.Respository.InventoryRepo;
import com.inventory.management.Inventory.Management.Services.DiscountTaxService;

@Service
public class DiscountTaxServiceimpl implements DiscountTaxService {

    @Autowired
    private DiscountTaxRepositpry discountTaxRepository;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public DiscountTaxEntity applyDiscountOrTax(Integer productId, Double discountPercentage, Double taxPercentage) {
        ProductEntitu product = inventoryRepo.findById(productId).orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        DiscountTaxEntity discountTax = new DiscountTaxEntity();
        discountTax.setProduct(product);
        discountTax.setDiscountPercentage(discountPercentage);
        discountTax.setTaxPercentage(taxPercentage);

        return discountTaxRepository.save(discountTax);
    }

    @Override
    public Double calculateFinalPrice(Integer productId) {
        ProductEntitu product = inventoryRepo.findById(productId).orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
        DiscountTaxEntity discountTax = discountTaxRepository.findByProduct_Productid(productId);

        double basePrice = product.getPrice();
        double finalPrice = basePrice;

        if (discountTax != null) {
            if (discountTax.getDiscountPercentage() != null) {
                finalPrice = basePrice - (basePrice * discountTax.getDiscountPercentage() / 100);
            } else if (discountTax.getTaxPercentage() != null) {
                finalPrice = basePrice + (basePrice * discountTax.getTaxPercentage() / 100);
            }
        }

        return finalPrice;
    }
}
