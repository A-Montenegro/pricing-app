package com.gft.pricingapp.price;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PriceRequest {

    @NotNull(message = "Product ID must not be null")
    @Positive(message = "Product ID must be positive")
    private Long productId;

    @NotNull(message = "Brand ID must not be null")
    @Positive(message = "Brand ID must be positive")
    private Long brandId;

    @NotNull(message = "Application date must not be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime applicationDate;

}
