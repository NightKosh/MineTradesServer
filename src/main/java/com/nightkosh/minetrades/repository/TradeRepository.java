package com.nightkosh.minetrades.repository;

import com.nightkosh.minetrades.model.TradeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TradeRepository extends CrudRepository<TradeEntity, Integer> {

    Iterable<TradeEntity> findByItemContains(@Param("item") String item);

    Iterable<TradeEntity> findByItemContainsAndItemContains(@Param("item") String item, @Param("enchantment") String enchantment);
}
