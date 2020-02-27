package com.forezp.learnspringbootstarter.httpstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhangZhuang
 * @date 2020/2/27
 * @description
 */

/**
 * @Configuration 声明是一个配置类
 */
@Configuration
/**
 * @EnableConfigurationProperties(HttpProperties.class) 所依赖的配置为HttpProperties
 */
@EnableConfigurationProperties(HttpProperties.class)
/**
 * 使用@ConditionalOnProperty注解来控制@Configuration是否生效
 * http.config.switch=enabled、或者缺少的时候，启用该配置
 * 配置的不是enabled时，启动报错是因为HttpClient没有注册到spring容器中，因为没有启用配置
 */
@ConditionalOnProperty(prefix = "http.config", value = "switch", havingValue = "enabled", matchIfMissing = true)
public class HttpAutoConfiguration {

    private final HttpProperties properties;

    public HttpAutoConfiguration(HttpProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean(HttpClient.class)
    public HttpClient httpClient() {
        HttpClient httpClient = new HttpClient();
        httpClient.setUrl(this.properties.getUrl());
        return httpClient;
    }
}
