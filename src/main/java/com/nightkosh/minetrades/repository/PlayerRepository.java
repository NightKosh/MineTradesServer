package com.nightkosh.minetrades.repository;

import com.nightkosh.minetrades.model.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository  extends CrudRepository<PlayerEntity, String> {

}
