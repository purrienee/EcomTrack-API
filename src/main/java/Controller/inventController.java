package Controller;

import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.Inventory.Management.DataModel.ProductEntitu;
import com.inventory.management.Inventory.Management.Services.InventService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class inventController {
    public InventService service;

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody ProductEntitu product) {
        
        return ResponseEntity.ok(service.createProduct(product));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Integer productId) {
        ProductEntitu product = service.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@RequestBody ProductEntitu product) {
        ProductEntitu updatedProduct = service.updateProduct(product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        service.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
    

     

