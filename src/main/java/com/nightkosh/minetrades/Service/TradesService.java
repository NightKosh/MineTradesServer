package com.nightkosh.minetrades.Service;

import com.nightkosh.minetrades.dto.TradeDto;
import com.nightkosh.minetrades.dto.TradesDto;
import com.nightkosh.minetrades.model.PlayerEntity;
import com.nightkosh.minetrades.model.TradeEntity;
import com.nightkosh.minetrades.repository.player.PlayerRepository;
import com.nightkosh.minetrades.repository.shop.TradeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TradesService {

    @Autowired
    TradeRepository tradeRepository;
    @Autowired
    PlayerRepository playerRepository;

    @Value("${UNKNOWN_PLAYER_NAME}")
    private String unknownPlayerName;

    public TradesDto getTrades(String item) {
        TradesDto tradesDto = new TradesDto();
        for (TradeEntity tradeEntity : tradeRepository.findByItemContains(item)) {
            String nick = playerRepository.findById(tradeEntity.getOwner())
                    .map(PlayerEntity::getNick)
                    .filter(StringUtils::isNotBlank)
                    .orElse(unknownPlayerName);
            tradesDto.addTrade(tradeEntity.getWorld(),
                    new TradeDto(nick, tradeEntity.getX(), tradeEntity.getY(), tradeEntity.getZ()));
        }
        return tradesDto;
    }
}
