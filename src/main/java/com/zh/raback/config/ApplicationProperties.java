package com.zh.raback.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Raback.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private String storage;
    private String nginxBase;

    public String getNginxBase() {
        return nginxBase;
    }

    public void setNginxBase(String nginxBase) {
        this.nginxBase = nginxBase;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
