package com.wellsfargo.app.config;

import com.wellsfargo.app.model.EmailProperties;
import com.wellsfargo.app.model.FileProperties;
import com.wellsfargo.app.model.LocationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties(prefix = "app.file.properties")
    public FileProperties fileProperties() {
        return new FileProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "app.directories.path")
    public LocationProperties locationProperties() {
        return new LocationProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "app.email.properties")
    public EmailProperties emailProperties() {
        return new EmailProperties();
    }
}
