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
@Entity(name = "freezers")
public class Freezer implements Storage {
    @Id
    private Long id;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "freezer",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<Product> products;
    @OneToOne
    private User user;

    public Freezer(User user) {
        this.products = new ArrayList<>();
        this.user = user;
    }
}
