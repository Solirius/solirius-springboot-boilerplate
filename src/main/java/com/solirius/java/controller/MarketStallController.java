package com.solirius.java.controller;

import com.solirius.java.domain.MarketStall;
import com.solirius.java.service.MarketStallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/market-stall")
public class MarketStallController {

    private MarketStallService marketStallService;

    @Autowired
    public MarketStallController(MarketStallService marketStallService) {
        this.marketStallService = marketStallService;
    }

    @PostMapping(value = "")
    public ResponseEntity<MarketStall> postMarketStall(@RequestBody MarketStall marketStall) {
        return ResponseEntity.ok(marketStallService.createdMarketStall(marketStall));
    }

    @GetMapping(value = "{uuid}")
    public ResponseEntity<MarketStall> getMarketStall(@PathVariable UUID uuid) {
        MarketStall marketStall = marketStallService.retriveMarketStall(uuid);
        if (marketStall != null) {
            return ResponseEntity.ok(marketStall);
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "{uuid}")
    public ResponseEntity<MarketStall> deleteMarketStall(@PathVariable UUID uuid,@RequestBody MarketStall marketStall) {
        marketStallService.updateMarektStall(uuid,marketStall);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{uuid}")
    public ResponseEntity<MarketStall> deleteMarketStall(@PathVariable UUID uuid) {
        marketStallService.deleteMarketStall(uuid);
        return ResponseEntity.noContent().build();
    }


}
