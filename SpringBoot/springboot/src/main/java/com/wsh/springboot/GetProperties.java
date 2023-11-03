package com.wsh.springboot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "userinfo")
@Data
public class GetProperties {

        private String name;

        private Integer age;
}
