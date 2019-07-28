package com.tony.cache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author tony
 * @describe CaffeineConfig
 * @date 2019-07-28
 */
@Configuration
public class CaffeineConfig {
    private static final int DEFAULT_SIZE = 10000;
    private static final int DEFAULT_TTL = 600;

    /**
     * 定义缓存的名字\超时时长(s)\最大容量
     * 每个cache缺省:10s超时\最多缓存50000条数据,需要修改可以在构造方法中修改
     */
    public enum Caches {
        getUserById(600),
        listsIpAddress(7200, 1000);

        Caches() {

        }

        Caches(int ttl) {
            this.ttl = ttl;
        }

        Caches(int ttl, int maxSize) {
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        private int maxSize = DEFAULT_SIZE;
        private int ttl = DEFAULT_TTL;

        public int getMaxSize() {
            return maxSize;
        }

        public int getTtl() {
            return ttl;
        }
    }

    /**
     * 主要配置相关的管理器
     *
     * @return
     */
    @Bean
    @Primary
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ArrayList<CaffeineCache> caches = new ArrayList<>();
        for (Caches c : Caches.values()) {
            caches.add(new CaffeineCache(c.name()
                    , Caffeine.newBuilder().recordStats().expireAfterWrite(c.getTtl()
                    , TimeUnit.SECONDS).maximumSize(c.getMaxSize()).build()));
        }
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
