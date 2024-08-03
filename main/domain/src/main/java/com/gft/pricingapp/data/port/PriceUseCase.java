package com.gft.pricingapp.data.port;

import com.gft.pricingapp.data.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PriceUseCase {
    PriceDTO findByCriteria(final Long productId, final Long brandId, final LocalDateTime applicationDate);
}
