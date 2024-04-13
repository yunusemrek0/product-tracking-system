package com.producttrackingsystem.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductPurchaseResponse {


    private LocalDate date;

    private String productName;

    private String dealerName;

    private Double purchasePrice;

    private Double amount;

    private Double discountRate;


}
