package com.gft.pricingapp;

import com.gft.pricingapp.dto.PriceDTO;
import com.gft.pricingapp.jparepository.price.PriceRepository;
import com.gft.pricingapp.usecase.PriceUseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PriceUseCaseImpl implements PriceUseCase {
    private final PriceRepository priceRepository;
    private final ModelMapper modelMapper;

    @Override
    public PriceDTO findByCriteria(final Long productId, final Long brandId, final LocalDateTime applicationDate) {
        final var price = priceRepository.findFirstByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                productId, brandId, applicationDate, applicationDate);

        return price.map(p -> modelMapper.map(p, PriceDTO.class))
                .orElseThrow(() -> new EntityNotFoundException("Price not found for the given criteria"));
    }
}
