package com.kitchen.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "shoppings")
public class Shopping implements Storage {
    @Id
    private Long id;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "shopping",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<Product> products;
    @OneToOne
    private User user;

    public Shopping(User user) {
        this.products = new ArrayList<>();
        this.user = user;
    }
}
