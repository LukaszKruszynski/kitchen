package com.kitchen.manager.product;

import com.kitchen.domain.Product;

public interface Manager<T1,T2> {
    void moveProduct(T1 from, T2 to, Product product);
}
