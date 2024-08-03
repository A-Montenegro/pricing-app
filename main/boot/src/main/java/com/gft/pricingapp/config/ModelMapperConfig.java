package com.gft.pricingapp.config;

import com.gft.pricingapp.data.dto.PriceDTO;
import com.gft.pricingapp.jparepository.price.Price;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        final var modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Price, PriceDTO>() {
            @Override
            protected void configure() {
                map().setBrandId(source.getBrand().getId());
                map().setProductId(source.getProduct().getId());
                map().setPriceRateDescription(source.getPriceRate().getDescription());
                map().setPrice(source.getValue());
            }
        });

        return modelMapper;
    }
}