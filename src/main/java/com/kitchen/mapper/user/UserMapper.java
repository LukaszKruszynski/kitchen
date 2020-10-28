package com.kitchen.mapper.user;

import com.kitchen.domain.User;
import com.kitchen.dto.UserDto;
import com.kitchen.mapper.product.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    ProductMapper productMapper;

    public User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                productMapper.mapToProducts(userDto.getProductDtos()));
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                productMapper.mapToProductDtos(user.getProducts()));
    }
}

