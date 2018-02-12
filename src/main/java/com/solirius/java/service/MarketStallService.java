package com.solirius.java.service;

import com.solirius.java.domain.MarketStall;
import com.solirius.java.exception.NotFoundException;
import com.solirius.java.repository.MarketStallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MarketStallService {

    private MarketStallRepository marketStallRepository;

    @Autowired
    public MarketStallService(MarketStallRepository marketStallRepository){
        this.marketStallRepository = marketStallRepository;
    }

    public MarketStall createdMarketStall(MarketStall marketStall){
        return marketStallRepository.save(marketStall);
    }

    public MarketStall retriveMarketStall(UUID uuid){
        return marketStallRepository.findOne(uuid);
    }

    public void updateMarektStall(UUID uuid, MarketStall marketStall){
        MarketStall orgMarketStall = retriveMarketStall(uuid);
        if(orgMarketStall != null){
            orgMarketStall.setName(marketStall.getName());
            orgMarketStall.setCusine(marketStall.getCusine());
            marketStallRepository.save(orgMarketStall);
        } else {
            throw new NotFoundException("no model found");
        }
    }

    public void deleteMarketStall(UUID uuid){
        marketStallRepository.delete(uuid);
    }



}
