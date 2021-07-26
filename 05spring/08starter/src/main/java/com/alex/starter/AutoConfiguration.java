package com.alex.starter;

import com.alex.starter.bean.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(AutoConfiguration.class)
@ConditionalOnProperty(prefix = "com.alex", value = "enabled", matchIfMissing = true)
public class AutoConfiguration {

    @Autowired
    private School school;

    @Bean
    @ConditionalOnMissingBean(School.class)
    public School AutoConfiguration() {
        return school;
    }
}
