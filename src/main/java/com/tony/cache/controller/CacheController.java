package com.tony.cache.controller;

import com.tony.cache.model.IPAddress;
import com.tony.cache.service.CacheService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/v1/cache")
public class CacheController {
    @Resource
    CacheService service;

    @RequestMapping("/test/{name}")
    @ResponseBody
    public String cacheTest(@PathVariable("name") String name) {
        Object o = service.getIfPresentCache(name);
        return o == null ? "返回对象为空" : o.toString();
    }

    /**
     * 通过springboot构建caffeine缓存
     */
    @Cacheable(value = "listIpAddress", key = "#length", sync = true)
    public List<IPAddress> listsIpAddress(Long length) {
        List<IPAddress> ipAddresses = new ArrayList<>();
        for (int i = 0; i <= length; i++) {
            IPAddress ipAddress = new IPAddress();
            ipAddresses.add(ipAddress);
        }
        return ipAddresses;
    }
}
