package com.kitchen.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn
    private Fridge fridge;
    @OneToOne
    @JoinColumn
    private Freezer freezer;
    @OneToOne
    @JoinColumn
    private Pantry pantry;
    @OneToOne
    @JoinColumn
    private Shopping shopping;
}
