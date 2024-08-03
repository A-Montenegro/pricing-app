package com.gft.pricingapp.jparepository.pricerate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRateRepository extends JpaRepository<PriceRate, Long> {
}
