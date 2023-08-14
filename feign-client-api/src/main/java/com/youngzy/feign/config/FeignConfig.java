package com.youngzy.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author youngzy
 * @since 2023-08-14
 */
public class FeignConfig {
    @Bean
    public Logger.Level loggerLevel() {
        return Logger.Level.BASIC;
    }
}
