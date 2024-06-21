package com.mal1as.service;

import com.mal1as.exception.ValidationException;
import com.mal1as.model.entity.Tax;
import com.mal1as.repository.TaxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaxService {

    private final TaxRepository taxRepository;

    @Transactional(readOnly = true)
    public Tax findByNumber(String taxNumber) {
        return taxRepository.findByCodePatternSimilarTo(taxNumber)
                .orElseThrow(() -> new ValidationException("Invalid tax number. " +
                        "No one tax pattern found for tax number = " + taxNumber));
    }
}
