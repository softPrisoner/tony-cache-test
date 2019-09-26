package com.tony.cache.ehcache.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author tony
 * @describe CacheConfiguration
 * @date 2019-09-27
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    //´´½¨ehcacheManager
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean ehCacheManagerFactoryBean) {
        return new EhCacheCacheManager(ehCacheManagerFactoryBean.getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        //load ehcache configuration
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        //set ehcache name
        ehCacheManagerFactoryBean.setCacheManagerName("ehcache");
        //share
        ehCacheManagerFactoryBean.setShared(true);

        return ehCacheManagerFactoryBean;
    }
}
