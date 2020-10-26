package com.kitchen.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "products")
public class Product {
    @Id
    private Long id;
    private String name;
    private String quantity;
    private String note;
    private Long barcode;
    private LocalDate expiryDate;
}
