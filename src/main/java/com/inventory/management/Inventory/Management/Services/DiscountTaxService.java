package com.inventory.management.Inventory.Management.Services;

import com.inventory.management.Inventory.Management.DataModel.DiscountTaxEntity;

public interface DiscountTaxService {
    DiscountTaxEntity applyDiscountOrTax(Integer productId, Double discountPercentage, Double taxPercentage);
    Double calculateFinalPrice(Integer productId);
}
