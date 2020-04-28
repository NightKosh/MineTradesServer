package com.nightkosh.minetrades.Service;

import com.nightkosh.minetrades.dto.TradeDto;
import com.nightkosh.minetrades.dto.TradesDto;
import com.nightkosh.minetrades.model.PlayerEntity;
import com.nightkosh.minetrades.model.TradeEntity;
import com.nightkosh.minetrades.repository.PlayerRepository;
import com.nightkosh.minetrades.repository.TradeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class TradesService {

    @Autowired
    TradeRepository tradeRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    ItemsService enchantmentsService;

    @Value("${configs.show_price}")
    private Boolean showPrice;

    @Value("${configs.player_name}")
    private String unknownPlayerName;

    public TradesDto getTrades(@NotNull String item, @Nullable String enchantment) {
        TradesDto tradesDto = new TradesDto();
        Iterable<TradeEntity> items;
        if (item.equals("ENCHANTED_BOOK") && StringUtils.isNotBlank(enchantment)) {
            items = tradeRepository.findByItemContainsAndItemContains("type: " + item + "\\n", enchantment);
        } else {
            items = tradeRepository.findByItemContains("type: " + item + "\\n");
        }
        for (TradeEntity tradeEntity : items) {
            String nick = playerRepository.findById(tradeEntity.getOwner())
                    .map(PlayerEntity::getNick)
                    .filter(StringUtils::isNotBlank)
                    .orElse(unknownPlayerName);
            TradeDto.ItemInfo itemInfo = enchantmentsService.getEnchantments(tradeEntity.getItem());
            tradesDto.addTrade(tradeEntity.getWorld(),
                    new TradeDto(nick,
                            showPrice ? tradeEntity.getPrice() : 0,
                            tradeEntity.getX(),
                            tradeEntity.getY(),
                            tradeEntity.getZ(),
                            tradeEntity.isSell(),
                            itemInfo));
        }
        return tradesDto;
    }
}
