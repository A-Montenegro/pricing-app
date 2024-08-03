package com.gft.pricingapp.usecase;

import com.gft.pricingapp.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PriceUseCase {
    PriceDTO findByCriteria(final Long productId, final Long brandId, final LocalDateTime applicationDate);
}
