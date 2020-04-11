package com.nightkosh.minetrades.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradesDto {

    private Map<String, List<TradeDto>> trades;

    public TradesDto() {
        trades = new HashMap<>();
    }

    public TradesDto(Map<String, List<TradeDto>> trades) {
        this.trades = trades;
    }

    public Map<String, List<TradeDto>> getTrades() {
        return trades;
    }

    public void setTrades(Map<String, List<TradeDto>> trades) {
        this.trades = trades;
    }

    public void addTrade(String world, TradeDto trade) {
        List<TradeDto> trades = this.trades.getOrDefault(world, new ArrayList<>());
        trades.add(trade);
        this.trades.put(world, trades);
    }
}
