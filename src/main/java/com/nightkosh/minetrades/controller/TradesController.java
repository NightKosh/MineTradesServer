package com.nightkosh.minetrades.controller;

import com.nightkosh.minetrades.Service.TradesService;
import com.nightkosh.minetrades.dto.TradeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class TradesController {

    @Autowired
    TradesService tradesService;

    @GetMapping("/search")
    @ResponseBody
    public Map<String, List<TradeDto>> search(
            @RequestParam(value = "item") String item,
            @RequestParam(value = "enchantment", required = false) String enchantment) {
        return tradesService.getTrades(item, enchantment).getTrades();
    }
}
