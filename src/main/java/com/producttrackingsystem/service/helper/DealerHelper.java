package com.producttrackingsystem.service.helper;

import com.producttrackingsystem.entity.Dealer;
import com.producttrackingsystem.exception.ResourceNotFoundException;
import com.producttrackingsystem.repository.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DealerHelper {

    private final DealerRepository dealerRepository;

    public Dealer isExistById(Long id){
        return dealerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("BAYİİ BULUNAMADI")
        );
    }
}
