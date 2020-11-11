package com.kitchen.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull
    private String name;
    private String quantity;
    private String note;
    private String barcode;
    private LocalDate expiryDate;
    @NotNull
    @Enumerated(EnumType.STRING)
    private StorageType storageType;

    public static final class ProductBuilder {
        private Long id;
        private String name;
        private String quantity;
        private String note;
        private String barcode;
        private LocalDate expiryDate;
        private StorageType storageType;

        public ProductBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder note(String note) {
            this.note = note;
            return this;
        }

        public ProductBuilder barcode(String barcode) {
            this.barcode = barcode;
            return this;
        }

        public ProductBuilder expiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public ProductBuilder storageType(StorageType storageType) {
            this.storageType = storageType;
            return this;
        }

        public Product build() {
            return new Product(id,name,quantity,note,barcode,expiryDate,storageType);
        }
    }
}
