package com.gft.pricingapp.jparepository.price;

import com.gft.pricingapp.jparepository.brand.Brand;
import com.gft.pricingapp.jparepository.pricerate.PriceRate;
import com.gft.pricingapp.jparepository.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    @Id
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne()
    @JoinColumn(name = "price_rate_id")
    private PriceRate priceRate;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priority;

    @Column(name = "price_value")
    private BigDecimal value;

    private String currency;
}