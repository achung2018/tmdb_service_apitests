package com.org.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ServiceTestBase {
    public static final Logger LOG = LoggerFactory.getLogger(ServiceTestBase.class);

    protected String api_key;
    private String baseUrl;

    public ServiceTestBase(String url) {
        this.baseUrl = url;
    }

    public ServiceTestBase(String url, String api_key) {
         this.baseUrl = url;
         this.api_key = api_key;
    }

    public String getServiceUrl() {
        return baseUrl;
    }

    public String getApi_key() {
        return api_key;
    }

    public abstract String configRequestPath(String op,String key);

    public String setApiKeyParam(String url) {
        return url + "?api_key=" + getApi_key();
    }
}

