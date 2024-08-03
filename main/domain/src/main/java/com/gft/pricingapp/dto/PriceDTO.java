package com.gft.pricingapp.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceDTO {
    private Long productId;
    private Long brandId;
    private String priceRateDescription;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
}
