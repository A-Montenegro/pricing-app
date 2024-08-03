package com.gft.pricingapp

import com.gft.pricingapp.config.ModelMapperConfig
import com.gft.pricingapp.dto.PriceDTO
import com.gft.pricingapp.jparepository.brand.Brand
import com.gft.pricingapp.jparepository.price.Price
import com.gft.pricingapp.jparepository.pricerate.PriceRate
import com.gft.pricingapp.jparepository.product.Product
import spock.lang.Specification

class ModelMapperConfigTest extends Specification {

    def modelMapperConfig = new ModelMapperConfig()

    def "modelMapper should be configured with correct mappings"() {
        given:
        def price = new Price()
        price.setBrand(new Brand(id: 1L))
        price.setProduct(new Product(id: 2L))
        price.setPriceRate(new PriceRate(description: "Standard"))
        price.setValue(100.0)

        when:
        def result = modelMapperConfig.modelMapper().map(price, PriceDTO)

        then:
        result.brandId == 1L
        result.productId == 2L
        result.priceRateDescription == "Standard"
        result.price == 100.0
    }
}