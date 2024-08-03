package com.gft.pricingapp.jparepository.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "product")
@Getter
public class Product {

    @Id
    private Long id;
    private String name;
}