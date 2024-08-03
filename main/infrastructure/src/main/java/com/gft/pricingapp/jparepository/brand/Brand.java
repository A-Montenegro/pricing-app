package com.gft.pricingapp.jparepository.brand;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "brand")
@Getter
public class Brand {

    @Id
    private Long id;
    private String name;

}