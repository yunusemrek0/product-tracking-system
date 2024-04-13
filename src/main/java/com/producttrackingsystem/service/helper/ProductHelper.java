package com.producttrackingsystem.service.helper;

import com.producttrackingsystem.entity.Product;
import com.producttrackingsystem.exception.ResourceNotFoundException;
import com.producttrackingsystem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductHelper {

    private final ProductRepository productRepository;

    public Product isExistById(Long id){
        return productRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("ÜRÜN BULUNAMADI")
        );
    }
}
