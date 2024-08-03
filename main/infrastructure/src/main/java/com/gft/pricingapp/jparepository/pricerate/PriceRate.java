package com.gft.pricingapp.jparepository.pricerate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "price_rate")
@Getter
public class PriceRate {

    @Id
    private Long id;
    private String description;
}