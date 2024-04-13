package com.producttrackingsystem.service;

import com.producttrackingsystem.entity.Dealer;
import com.producttrackingsystem.entity.Product;
import com.producttrackingsystem.entity.ProductPurchase;
import com.producttrackingsystem.payload.mapper.ProductPurchaseMapper;
import com.producttrackingsystem.payload.request.ProductPurchaseRequest;
import com.producttrackingsystem.payload.response.ProductPurchaseResponse;
import com.producttrackingsystem.repository.ProductPurchaseRepository;
import com.producttrackingsystem.service.helper.DealerHelper;
import com.producttrackingsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductPurchaseService {

    private final ProductPurchaseRepository productPurchaseRepository;
    private final ProductHelper productHelper;
    private final DealerHelper dealerHelper;
    private final ProductPurchaseMapper productPurchaseMapper;


    public String saveProductPurchase(ProductPurchaseRequest productPurchaseRequest) {
        Product product = productHelper.isExistById(productPurchaseRequest.getProductId());
        Dealer dealer = dealerHelper.isExistById(productPurchaseRequest.getDealerId());

        ProductPurchase productPurchaseToSave = productPurchaseMapper.mapProductPurchaseRequestToProductPurchase(productPurchaseRequest);
        productPurchaseToSave.setProduct(product);
        productPurchaseToSave.setDealer(dealer);

        productPurchaseRepository.save(productPurchaseToSave);

        return null;

    }

    public List<ProductPurchaseResponse> getByProduct(Long id) {
        return productPurchaseRepository.getByProductId(id)
                .stream()
                .map(productPurchaseMapper::mapProductPurchaseToProductPurchaseResponse)
                .collect(Collectors.toList());
    }

    public List<ProductPurchaseResponse> getByDealer(Long id) {
        return productPurchaseRepository.getByDealerId(id)
                .stream()
                .map(productPurchaseMapper::mapProductPurchaseToProductPurchaseResponse)
                .collect(Collectors.toList());
    }

    public List<ProductPurchaseResponse> getAll() {
        return productPurchaseRepository.findAll()
                .stream()
                .map(productPurchaseMapper::mapProductPurchaseToProductPurchaseResponse)
                .collect(Collectors.toList());
    }
}
