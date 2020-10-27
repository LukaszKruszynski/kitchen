package com.kitchen.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "products")
public class Product {
    @Id
    private Long id;
    private String name;
    private String quantity;
    private String note;
    private Long barcode;
    private LocalDate expiryDate;
    @ManyToOne
    @JoinColumn
    private Fridge fridge;
    @ManyToOne
    @JoinColumn
    private Freezer freezer;
    @ManyToOne
    @JoinColumn
    private Pantry pantry;
    @ManyToOne
    @JoinColumn
    private Shopping shopping;

    public Product(Long id, String name, String quantity, String note, Long barcode, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.note = note;
        this.barcode = barcode;
        this.expiryDate = expiryDate;
    }
}
