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
@Entity(name = "fridges")
public class Fridge implements Storage {
    @Id
    private Long id;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "fridge",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<Product> products;
    @OneToOne
    private User user;

    public Fridge(User user) {
        this.products = new ArrayList<>();
        this.user = user;
    }
}
