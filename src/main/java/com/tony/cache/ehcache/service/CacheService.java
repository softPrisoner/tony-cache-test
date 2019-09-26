package com.tony.cache.ehcache.service;

import com.tony.cache.ehcache.model.ProductInfo;

/**
 * »º´æ·þÎñÀà
 * @author tony
 * @describe CacheService
 * @date 2019-09-27
 */
public interface CacheService {
    public ProductInfo saveLocalCache(ProductInfo productInfo);
    public ProductInfo getLocalCache(Long id);
}
