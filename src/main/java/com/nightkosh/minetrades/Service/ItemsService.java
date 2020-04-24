package com.nightkosh.minetrades.Service;

import com.nightkosh.minetrades.dto.TradeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemsService {

    private static final Logger log = LoggerFactory.getLogger(ItemsService.class);

    public TradeDto.ItemInfo getEnchantments(String item) {
        Map<String, Integer> enchantments = new HashMap<>();
        Iterator<String> it =  Arrays.asList(item.split("\\\\n")).iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.contains("stored-enchants:") || str.contains("enchants:")) {
                int i = getIndent(str);
                while (it.hasNext()) {
                    String subStr = it.next();
                    if (getIndent(subStr) == i + 2) {
                        String[] str1 =  subStr.replaceAll(" ", "").split(":");
                        try {
                            enchantments.put(str1[0], Integer.valueOf(str1[1]));
                        } catch (NumberFormatException e) {
                            log.error(String.format("Can't parse enchantment : %s", subStr));
                        }
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        String name = null;
        int pos = item.indexOf("display-name:");
        if (pos != -1) {
            try {
                name = item.substring(pos);
                name = name.substring(14, name.indexOf("\\n"));
            } catch (StringIndexOutOfBoundsException e) {
                name = null;
                log.error(String.format("Can't parse item name"));
            }
        }
        return TradeDto.ItemInfo.getItemInfo(name, enchantments);
    }

    /**
     * Calculate amount of whitespaces at the beginning of the string
     */
    private static int getIndent(String str) {
        return str.length() - str.replaceAll("^\\s+", "").length();
    }
}
