package com.nightkosh.minetrades.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "playerEntityManagerFactory",
        basePackages = {"com.nightkosh.minetrades.repository.player"}
)
public class PlayerDbConfig {

    @Bean(name = "playerDataSource")
    @ConfigurationProperties(prefix = "player.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "playerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean playerEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("playerDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.nightkosh.minetrades.model")
                .persistenceUnit("PlayerEntity")
                .build();
    }
}
