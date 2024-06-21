package com.mal1as.service;

import com.mal1as.exception.ValidationException;
import com.mal1as.model.entity.Product;
import com.mal1as.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Product not found by id = " + id));
    }
}
