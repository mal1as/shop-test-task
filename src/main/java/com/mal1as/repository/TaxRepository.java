package com.mal1as.repository;

import com.mal1as.model.entity.Tax;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TaxRepository extends CrudRepository<Tax, Long> {

    @Query(nativeQuery = true, value = "select * from tax t where :tax_number similar to t.code_pattern")
    Optional<Tax> findByCodePatternSimilarTo(@Param("tax_number") String taxNumber);
}
