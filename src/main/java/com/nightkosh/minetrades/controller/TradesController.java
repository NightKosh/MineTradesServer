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
    public Map<String, List<TradeDto>> greeting(@RequestParam(value = "item") String item) {
        return tradesService.getTrades(item).getTrades();
    }
}
