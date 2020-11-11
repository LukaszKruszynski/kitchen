package com.kitchen.mapper.product;

import com.kitchen.domain.Product;
import com.kitchen.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product.ProductBuilder()
                .id(productDto.getId())
                .name(productDto.getName())
                .quantity(productDto.getQuantity())
                .note(productDto.getNote())
                .barcode(productDto.getBarcode())
                .expiryDate(productDto.getExpiryDate())
                .storageType(productDto.getStorageType())
                .build();
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto.ProductDtoBuilder()
                .id(product.getId())
                .name(product.getName())
                .quantity(product.getQuantity())
                .note(product.getNote())
                .barcode(product.getBarcode())
                .expiryDate(product.getExpiryDate())
                .storageType(product.getStorageType())
                .build();
    }

    public List<Product> mapToProducts(final List<ProductDto> productDtos) {
        return productDtos.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }

    public List<ProductDto> mapToProductsDtos(final List<Product> products) {
        return products.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
