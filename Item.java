package com.example.demo; // Corrected package name

import jakarta.persistence.*;  // Import necessary JPA annotations

@Entity
@Table(name = "items") // Optional: Specify table name
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name") //Optional specify column name
    private String name;

    @Column(name = "description") //Optional specify column name
    private String description;

    // Default constructor (required by JPA)
    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {  // Optional: Setter if you need it.
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}