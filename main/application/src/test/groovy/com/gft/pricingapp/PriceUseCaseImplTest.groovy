package com.gft.pricingapp

import com.gft.pricingapp.dto.PriceDTO
import com.gft.pricingapp.jparepository.price.Price
import com.gft.pricingapp.jparepository.price.PriceRepository
import jakarta.persistence.EntityNotFoundException
import org.modelmapper.ModelMapper
import spock.lang.Specification

import java.time.LocalDateTime

class PriceUseCaseImplTest extends Specification {

    def priceRepository = Mock(PriceRepository.class)
    def modelMapper = Mock(ModelMapper.class)
    def priceUseCaseImpl = new PriceUseCaseImpl(priceRepository, modelMapper)

    def "findByCriteria() should call priceRepository and model mapper with correct parameters"() {
        given:
        def productId = 35445L
        def brandId = 1L
        def applicationDate = LocalDateTime.now()
        def price = new Price()
        def priceDTO = new PriceDTO()

        when:
        def result = priceUseCaseImpl.findByCriteria(productId, brandId, applicationDate)

        then:
        1 * priceRepository.findFirstByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(productId, brandId, applicationDate, applicationDate) >> Optional.of(price)
        1 * modelMapper.map(price, PriceDTO.class) >> priceDTO
        result == priceDTO
    }

    def "findByCriteria() should throw exception when no price is found"() {
        when:
        priceUseCaseImpl.findByCriteria(0, 0, LocalDateTime.now())

        then:
        1 * priceRepository.findFirstByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(0, 0, _, _) >> Optional.empty()
        def e = thrown EntityNotFoundException
        e.message == "Price not found for the given criteria"
    }
}