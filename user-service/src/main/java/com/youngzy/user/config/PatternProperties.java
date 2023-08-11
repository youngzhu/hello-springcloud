package com.youngzy.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author youngzy
 * @since 2023-08-11
 */
@ConfigurationProperties("pattern")
@Component
@Data
public class PatternProperties {
    private String dateformat;
}
