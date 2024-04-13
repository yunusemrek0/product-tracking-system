package com.producttrackingsystem.payload.mapper;

import com.producttrackingsystem.entity.ProductPurchase;
import com.producttrackingsystem.payload.request.ProductPurchaseRequest;
import com.producttrackingsystem.payload.response.ProductPurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ProductPurchaseMapper {


    public ProductPurchase mapProductPurchaseRequestToProductPurchase(ProductPurchaseRequest productPurchaseRequest){

        return ProductPurchase.builder()
                .purchasePrice(priceCalculator(productPurchaseRequest.getPurchasePrice(),
                        productPurchaseRequest.getDiscountRate()))
                .amount(productPurchaseRequest.getAmount())
                .discountRate(productPurchaseRequest.getDiscountRate())
                .date(LocalDate.now())
                .build();
    }

    public ProductPurchaseResponse mapProductPurchaseToProductPurchaseResponse(ProductPurchase productPurchase){

        return ProductPurchaseResponse.builder()
                .purchasePrice(productPurchase.getPurchasePrice())
                .amount(productPurchase.getAmount())
                .productName(productPurchase.getProduct().getName())
                .discountRate(productPurchase.getDiscountRate())
                .date(productPurchase.getDate())
                .dealerName(productPurchase.getDealer().getName())
                .build();
    }


    private Double priceCalculator(Double price,Double discountRate){
        return price - (price*discountRate/100);
    }
}
