package com.tony.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author tony
 * @describe CacheTestApplication
 * @date 2019-07-28
 */
@SpringBootApplication
@EnableCaching
public class CacheTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheTestApplication.class, args);
    }
}
