package com.producttrackingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product_purchase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate date;

    @ManyToOne
    private Product product;

    private Double purchasePrice;

    private Double amount;

    private Double discountRate;

    @ManyToOne
    private Dealer dealer;
}
