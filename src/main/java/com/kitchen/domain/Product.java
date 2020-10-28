package com.kitchen.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "products")
public class Product {
    @Id
    private Long id;
    private String name;
    private String quantity;
    private String note;
    private Long barcode;
    private LocalDate expiryDate;
    @Enumerated(EnumType.STRING)
    private StorageType storageType;
    @ManyToOne
    @JoinColumn
    private User user;

    public static final class ProductBuilder {
        private Long id;
        private String name;
        private String quantity;
        private String note;
        private Long barcode;
        private LocalDate expiryDate;
        private StorageType storageType;
        private User user;

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

        public ProductBuilder barcode(Long barcode) {
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

        public ProductBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Product build() {
            return new Product(id,name,quantity,note,barcode,expiryDate,storageType,user);
        }
    }
}
