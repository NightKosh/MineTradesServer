package com.nightkosh.minetrades.model;

import com.nightkosh.minetrades.model.converter.OwnerConverter;
import com.nightkosh.minetrades.model.converter.TradeTypeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "shops")
@IdClass(TradeEntity.TradeEntityId.class)
public class TradeEntity {

    @Convert(converter = OwnerConverter.class)
    private String owner;
    private double price;
    @Column(name="itemconfig")
    private String item;
    @Id
    private String world;
    @Id
    private int x;
    @Id
    private int y;
    @Id
    private int z;
    @Column(name="type")
    @Convert(converter = TradeTypeConverter.class)
    private boolean sell;

    public TradeEntity() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public boolean isSell() {
        return sell;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return String.format("%s %dx%dx%d", this.owner, this.x, this.y, + this.z);
    }

    public static final class TradeEntityId implements Serializable {

        private String world;
        private int x;
        private int y;
        private int z;

        public TradeEntityId() {
        }

        public TradeEntityId(String world, int x, int y, int z) {
            this.world = world;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TradeEntityId that = (TradeEntityId) o;
            return x == that.x &&
                    y == that.y &&
                    z == that.z &&
                    world.equals(that.world);
        }

        @Override
        public int hashCode() {
            return Objects.hash(world, x, y, z);
        }
    }
}
