package com.producttrackingsystem.service;

import com.producttrackingsystem.entity.Dealer;
import com.producttrackingsystem.payload.mapper.DealerMapper;
import com.producttrackingsystem.payload.request.DealerRequest;
import com.producttrackingsystem.payload.response.DealerResponse;
import com.producttrackingsystem.repository.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DealerService {

    private final DealerRepository dealerRepository;
    private final DealerMapper dealerMapper;



    public String saveDealer(DealerRequest dealerRequest) {

        Dealer dealerToSave = dealerMapper.mapDealerRequestToDealer(dealerRequest);
        dealerRepository.save(dealerToSave);

        return null;
    }

    public List<DealerResponse> getAll() {

        return dealerRepository.findAll()
                .stream()
                .map(dealerMapper::mapDealerToDealerResponse)
                .collect(Collectors.toList());
    }
}
