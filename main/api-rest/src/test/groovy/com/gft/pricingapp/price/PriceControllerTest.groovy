package com.gft.pricingapp.price

import com.gft.pricingapp.dto.PriceDTO
import com.gft.pricingapp.usecase.PriceUseCase
import spock.lang.Specification

import java.time.LocalDateTime

class PriceControllerTest extends Specification {

    def priceUseCase = Mock(PriceUseCase.class)
    def priceController = new PriceController(priceUseCase)

    def "findByCriteria() should return correct response entity"() {
        given:
        def productId = 35445L
        def brandId = 1L
        def applicationDate = LocalDateTime.now()
        def priceDTO = new PriceDTO()
        def priceRequest = new PriceRequest(productId, brandId, applicationDate)

        when:
        def result = priceController.findByCriteria(priceRequest)

        then:
        1 == 1
        1 * priceUseCase.findByCriteria(productId, brandId, applicationDate) >> priceDTO
        result.statusCode.value() == 200
        result.body == priceDTO
    }
}