package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventory.management.Inventory.Management.DataModel.DiscountTaxEntity;
import com.inventory.management.Inventory.Management.Services.DiscountTaxService;

@RestController
@RequestMapping("/api")
public class DiscountTaxController {

    @Autowired
    private DiscountTaxService discountTaxService;

    @PostMapping("/product/{productId}/apply-discount-tax")
    public ResponseEntity<?> applyDiscountOrTax(@PathVariable Integer productId,
                                                @RequestParam(required = false) Double discountPercentage,
                                                @RequestParam(required = false) Double taxPercentage) {
        DiscountTaxEntity discountTax = discountTaxService.applyDiscountOrTax(productId, discountPercentage, taxPercentage);
        return ResponseEntity.ok(discountTax);
    }

    @GetMapping("/product/{productId}/final-price")
    public ResponseEntity<?> calculateFinalPrice(@PathVariable Integer productId) {
        Double finalPrice = discountTaxService.calculateFinalPrice(productId);
        return ResponseEntity.ok(finalPrice);
    }
}
