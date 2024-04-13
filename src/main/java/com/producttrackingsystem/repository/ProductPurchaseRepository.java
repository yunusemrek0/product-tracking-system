package com.producttrackingsystem.repository;

import com.producttrackingsystem.entity.ProductPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPurchaseRepository extends JpaRepository<ProductPurchase,Long> {

    List<ProductPurchase> getByProductId(Long productId);

    List<ProductPurchase> getByDealerId(Long dealerId);


}
