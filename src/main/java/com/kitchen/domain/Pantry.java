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
@Entity(name = "pantries")
public class Pantry implements Storage {
    @Id
    private Long id;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "pantry",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<Product> products;
    @OneToOne
    private User user;

    public Pantry(User user) {
        this.products = new ArrayList<>();
        this.user = user;
    }
}
