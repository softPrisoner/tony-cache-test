package com.tony.cache.ehcache.controller;

import com.tony.cache.caffeine.model.IPAddress;
import com.tony.cache.ehcache.model.ProductInfo;
import com.tony.cache.ehcache.service.CacheService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tony
 * @describe CacheController
 * @date 2019-07-27
 */
@Controller
@RequestMapping("/v1/ehcache")
public class CacheController {
    @Resource
    CacheService service;

    /**
     * product info put
     * @param id product id
     * @param name product name
     * @param price product price
     * @return cache product info
     */
    @RequestMapping("/test/put")
    @ResponseBody
    public ProductInfo cacheTest(@RequestParam long id, @RequestParam String name, @RequestParam double price) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setName(name);
        productInfo.setPrice(price);
        ProductInfo cacheProductInfo = service.saveLocalCache(productInfo);
        return cacheProductInfo;
    }

    /**
     * ehcache test get
     * @param id product id
     * @return info
     */
    @RequestMapping("/test/get/{id}")
    @ResponseBody
    public ProductInfo cacheTest(@PathVariable("id") Long id) {
        return service.getLocalCache(id);
    }

    /**
     * 通过springboot构建caffeine缓存
     */
    @RequestMapping("/test/addr")
    @Cacheable(value = "listsIpAddress", key = "#length", sync = true)
    public List<IPAddress> listsIpAddress(Long length) {
        List<IPAddress> ipAddresses = new ArrayList<>();
        for (int i = 0; i <= length; i++) {
            IPAddress ipAddress = new IPAddress();
            ipAddresses.add(ipAddress);
        }
        return ipAddresses;
    }
}
