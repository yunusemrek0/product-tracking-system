package com.producttrackingsystem.controller;

import com.producttrackingsystem.payload.request.ProductPurchaseRequest;
import com.producttrackingsystem.payload.response.ProductPurchaseResponse;
import com.producttrackingsystem.service.ProductPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/productPurchase")
@RequiredArgsConstructor
public class ProductPurchaseController {

    private final ProductPurchaseService productPurchaseService;


    @PostMapping("/save")
    public ResponseEntity<String> saveProductPurchase(@Valid @RequestBody ProductPurchaseRequest productPurchaseRequest){
        return ResponseEntity.ok(productPurchaseService.saveProductPurchase(productPurchaseRequest));
    }

    @GetMapping("/getByProduct/{id}")
    public ResponseEntity<List<ProductPurchaseResponse>> getByProduct(@PathVariable Long id){
        return ResponseEntity.ok(productPurchaseService.getByProduct(id));
    }

    @GetMapping("/getByDealer/{id}")
    public ResponseEntity<List<ProductPurchaseResponse>> getByDealer(@PathVariable Long id){
        return ResponseEntity.ok(productPurchaseService.getByDealer(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductPurchaseResponse>> getAll(){
        return ResponseEntity.ok(productPurchaseService.getAll());
    }
}
