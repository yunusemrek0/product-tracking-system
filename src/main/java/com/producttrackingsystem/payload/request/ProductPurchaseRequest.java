package com.producttrackingsystem.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPurchaseRequest {


    private Long productId;

    private Double purchasePrice;

    private Double amount;

    private Double discountRate;

    private Long dealerId;
}
