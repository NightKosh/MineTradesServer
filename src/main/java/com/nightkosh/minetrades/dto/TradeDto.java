package com.nightkosh.minetrades.dto;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class TradeDto {

    private String seller;
    private int x;
    private int y;
    private int z;

    private ItemInfo itemInfo;

    public TradeDto() {
    }

    public TradeDto(String seller, int x, int yPos, int zPos, ItemInfo itemInfo) {
        this.seller = seller;
        this.x = x;
        this.y = yPos;
        this.z = zPos;
        this.itemInfo = itemInfo;
    }

    public String getSeller() {
        return seller;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    @Override
    public String toString() {
        return String.format("%s %dx%dx%d", this.seller, this.x, this.y, + this.z);
    }

    public static class ItemInfo {

        private String name;
        private Map<String, Integer> enchantments;

        private ItemInfo(String name, Map<String, Integer> enchantments) {
            this.name = name;
            this.enchantments = enchantments;
        }

        public static ItemInfo getItemInfo(String name, Map<String, Integer> enchantments) {
            if (enchantments.isEmpty()) {
                enchantments = null;
                if (StringUtils.isBlank(name)) {
                    return null;
                }
            }
            return new ItemInfo(name, enchantments);
        }

        public String getName() {
            return name;
        }

        public Map<String, Integer> getEnchantments() {
            return enchantments;
        }
    }
}
