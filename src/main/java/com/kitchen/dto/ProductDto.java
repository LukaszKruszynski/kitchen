package com.kitchen.dto;

import com.kitchen.domain.StorageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String quantity;
    private String note;
    private Long barcode;
    private LocalDate expiryDate;
    private StorageType storageType;
    private UserDto userDto;

    public static final class ProductDtoBuilder {
        private Long id;
        private String name;
        private String quantity;
        private String note;
        private Long barcode;
        private LocalDate expiryDate;
        private StorageType storageType;
        private UserDto userDto;

        public ProductDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductDtoBuilder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductDtoBuilder note(String note) {
            this.note = note;
            return this;
        }

        public ProductDtoBuilder barcode(Long barcode) {
            this.barcode = barcode;
            return this;
        }

        public ProductDtoBuilder expiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public ProductDtoBuilder storageType(StorageType storageType) {
            this.storageType = storageType;
            return this;
        }

        public ProductDtoBuilder userDto(UserDto userDto) {
            this.userDto = userDto;
            return this;
        }

        public ProductDto build() {
            return new ProductDto(id, name, quantity, note, barcode, expiryDate, storageType, userDto);
        }
    }
}
