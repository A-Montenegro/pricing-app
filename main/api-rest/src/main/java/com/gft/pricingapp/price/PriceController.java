package com.gft.pricingapp.price;


import com.gft.pricingapp.data.dto.PriceDTO;
import com.gft.pricingapp.data.port.PriceUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/price")
@Validated
public class PriceController {

    private final PriceUseCase priceUseCase;

    @GetMapping
    public ResponseEntity<PriceDTO> findByCriteria(@Valid @ModelAttribute final PriceRequest priceRequest) {
        return ResponseEntity.ok(priceUseCase.findByCriteria(priceRequest.getProductId(), priceRequest.getBrandId(),
                                                             priceRequest.getApplicationDate()));
    }
}
