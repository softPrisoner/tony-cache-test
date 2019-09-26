package com.tony.cache.ehcache.service.impl;

import com.tony.cache.ehcache.model.ProductInfo;
import com.tony.cache.ehcache.service.CacheService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author tony
 * @describe CacheServiceImpl
 * @date 2019-09-27
 */
public class CacheServiceImpl implements CacheService {
    private static final String CACHE_NAME = "local";

    @Override
    @CachePut(cacheNames = {CACHE_NAME}, key = "'key_'+#productInfo.getId()")
    public ProductInfo saveLocalCache(ProductInfo productInfo) {
        return productInfo;
    }

    @Override
    @Cacheable(cacheNames = {CACHE_NAME}, key = "'key_'+#id")
    public ProductInfo getLocalCache(Long id) {
        return null;
    }
}
