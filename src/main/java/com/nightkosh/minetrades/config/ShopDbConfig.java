package com.nightkosh.minetrades.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "shopEntityManagerFactory",
        basePackages = {"com.nightkosh.minetrades.repository.shop"}
)
public class ShopDbConfig {

    @Primary
    @Bean(name = "shopDataSource")
    @ConfigurationProperties(prefix = "shop.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "shopEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("shopDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.nightkosh.minetrades.model")
                .persistenceUnit("TradeEntity")
                .build();
    }
}
