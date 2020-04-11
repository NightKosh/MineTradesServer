package com.nightkosh.minetrades.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "myskin_uuid")
public class PlayerEntity {

    @Id
    private String uuid;

    private String nick;

    public PlayerEntity() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
