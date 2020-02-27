package com.forezp.learnspringbootstarter.httpstarter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ZhangZhuang
 * @date 2020/2/27
 * @description
 */
@ConfigurationProperties(prefix = "http")
@Getter
@Setter
public class HttpProperties {
    // 如果配置了属性，则该属性会被覆盖
    private String url = "http://www.baidu.com";
}
