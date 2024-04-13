package com.producttrackingsystem.payload.mapper;


import com.producttrackingsystem.entity.Product;
import com.producttrackingsystem.payload.request.ProductRequest;
import com.producttrackingsystem.payload.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    public Product mapProductRequestToProduct(ProductRequest productRequest){
        return Product.builder()
                .barcode(productRequest.getBarcode())
                .name(productRequest.getName())
                .build();
    }

    public ProductResponse mapProductToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .barcode(product.getBarcode())
                .build();
    }
}
