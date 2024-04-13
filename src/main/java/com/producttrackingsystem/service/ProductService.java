package com.producttrackingsystem.service;

import com.producttrackingsystem.entity.Product;
import com.producttrackingsystem.payload.mapper.ProductMapper;
import com.producttrackingsystem.payload.request.ProductRequest;
import com.producttrackingsystem.payload.response.ProductResponse;
import com.producttrackingsystem.repository.ProductRepository;
import com.producttrackingsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductHelper productHelper;


    public String saveProduct(ProductRequest productRequest) {

        Product productToSave = productMapper.mapProductRequestToProduct(productRequest);
        productRepository.save(productToSave);

        return null;
    }

    public String updateProduct(ProductRequest productRequest, Long id) {
        productHelper.isExistById(id);

        Product productToUpdate = productMapper.mapProductRequestToProduct(productRequest);
        productToUpdate.setId(id);

        productRepository.save(productToUpdate);

        return null;
    }

    public List<ProductResponse> getAll() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::mapProductToProductResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getById(Long id) {
        return productMapper.mapProductToProductResponse(
                productHelper.isExistById(id)
        );
    }
}
