package com.nightkosh.minetrades.dto;

public class TradeDto {

    private String seller;
    private int x;
    private int y;
    private int z;

    public TradeDto() {
    }

    public TradeDto(String seller, int x, int yPos, int zPos) {
        this.seller = seller;
        this.x = x;
        this.y = yPos;
        this.z = zPos;
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

    @Override
    public String toString() {
        return String.format("%s %dx%dx%d", this.seller, this.x, this.y, + this.z);
    }
}
