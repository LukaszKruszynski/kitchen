package com.kitchen.mapper.product;

import com.kitchen.domain.Product;
import com.kitchen.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
   public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getId(),
                productDto.getName(),
                productDto.getQuantity(),
                productDto.getNote(),
                productDto.getBarcode(),
                productDto.getExpiryDate());
   }

   public ProductDto mapToProductDto(final Product product) {
       return new ProductDto(product.getId(),
               product.getName(),
               product.getQuantity(),
               product.getNote(),
               product.getBarcode(),
               product.getExpiryDate());
   }

   public List<Product> mapToProducts(final List<ProductDto> productDtos) {
        return productDtos.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
   }

   public List<ProductDto> mapToProductDtos(final List<Product> products) {
       return products.stream()
               .map(this::mapToProductDto)
               .collect(Collectors.toList());
   }
}
