package com.wqy.boot.core.service.impl;

import com.github.benmanes.caffeine.cache.Cache;
import com.wqy.boot.core.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * CacheService实现类
 */
@Service
public class CacheServiceImpl implements CacheService {

    private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

    @Autowired
    Cache<String, Object> caffeineCache;

    @Override
    public String getCache() {
        caffeineCache.getIfPresent("testCache");
        String cache = (String) caffeineCache.asMap().get("testCache");
        if (!StringUtils.isEmpty(cache)) {
            logger.info("Get cache");
            return cache;
        }
        caffeineCache.put("testCache", "getCaffeineCache");
        logger.info("Put cache");
        return "getCaffeineCache";
    }

    @Override
    public void updateCache(String cacheStr) {
        caffeineCache.put("testCache", cacheStr);
        logger.info("Update cache");
    }
}
