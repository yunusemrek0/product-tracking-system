package com.producttrackingsystem.payload.mapper;

import com.producttrackingsystem.entity.Dealer;
import com.producttrackingsystem.payload.request.DealerRequest;
import com.producttrackingsystem.payload.response.DealerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DealerMapper {

    public Dealer mapDealerRequestToDealer(DealerRequest dealerRequest){
       return Dealer.builder()
               .name(dealerRequest.getName())
               .build();
    }

    public DealerResponse mapDealerToDealerResponse(Dealer dealer){
        return DealerResponse.builder()
                .id(dealer.getId())
                .name(dealer.getName())
                .build();
    }
}
