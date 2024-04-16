package com.producttrackingsystem.controller;

import com.producttrackingsystem.payload.request.DealerRequest;
import com.producttrackingsystem.payload.response.DealerResponse;
import com.producttrackingsystem.service.DealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dealer")
@RequiredArgsConstructor
public class DealerController {

    private final DealerService dealerService;


    @PostMapping("/save")
    public ResponseEntity<String> saveDealer(@Valid @RequestBody DealerRequest dealerRequest){
        return ResponseEntity.ok(dealerService.saveDealer(dealerRequest));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<DealerResponse>> getAll(){
        return ResponseEntity.ok(dealerService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DealerResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(dealerService.getById(id));
    }



}
