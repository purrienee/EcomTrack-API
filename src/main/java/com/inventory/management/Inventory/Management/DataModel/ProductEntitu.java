package com.inventory.management.Inventory.Management.DataModel;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
public class ProductEntitu {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productid;
    String name;
    String description;
    Double price;
    int quantityAvail;
}
