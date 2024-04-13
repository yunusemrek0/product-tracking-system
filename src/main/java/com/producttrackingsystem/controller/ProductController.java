package com.producttrackingsystem.controller;


import com.producttrackingsystem.payload.request.DealerRequest;
import com.producttrackingsystem.payload.request.ProductRequest;
import com.producttrackingsystem.payload.response.DealerResponse;
import com.producttrackingsystem.payload.response.ProductResponse;
import com.producttrackingsystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productService.saveProduct(productRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@Valid @RequestBody ProductRequest productRequest,
                                                @PathVariable Long id){
        return ResponseEntity.ok(productService.updateProduct(productRequest,id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductResponse>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getById(id));
    }
}
