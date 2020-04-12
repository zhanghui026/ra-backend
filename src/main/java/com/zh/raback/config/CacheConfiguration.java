package com.zh.raback.config;

import java.time.Duration;

import com.zh.raback.domain.Artist;
import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import org.hibernate.cache.jcache.ConfigSettings;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
        return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            createCache(cm, com.zh.raback.repository.UserRepository.USERS_BY_LOGIN_CACHE);
            createCache(cm, com.zh.raback.repository.UserRepository.USERS_BY_EMAIL_CACHE);
            createCache(cm, com.zh.raback.domain.User.class.getName());
            createCache(cm, com.zh.raback.domain.Authority.class.getName());
            createCache(cm, com.zh.raback.domain.User.class.getName() + ".authorities");
            createCache(cm, com.zh.raback.domain.Post.class.getName());
            createCache(cm, com.zh.raback.domain.Client.class.getName());
            createCache(cm, com.zh.raback.domain.Category.class.getName());
            createCache(cm, com.zh.raback.domain.Product.class.getName());
            createCache(cm, com.zh.raback.domain.FileManager.class.getName());
            createCache(cm, com.zh.raback.domain.Customer.class.getName());
            createCache(cm, com.zh.raback.domain.Command.class.getName());
            createCache(cm, com.zh.raback.domain.Invoice.class.getName());
            createCache(cm, com.zh.raback.domain.Review.class.getName());
            createCache(cm, Artist.class.getName());
            createCache(cm, com.zh.raback.domain.Painting.class.getName());
            // jhipster-needle-ehcache-add-entry
        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache == null) {
            cm.createCache(cacheName, jcacheConfiguration);
        }
    }

}
