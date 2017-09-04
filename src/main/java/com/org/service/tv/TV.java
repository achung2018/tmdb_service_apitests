package com.org.service.tv;

import com.org.service.ServiceTestBase;
import com.org.util.PropertiesLoader;

public class TV extends ServiceTestBase {
    private String tvRequestPath;
    private final String tvPathParam = "/{tv_id}";

    public TV() {
        super(PropertiesLoader.getBasePath(),System.getProperty("apikey"));
    }

    @Override
    public String configRequestPath(String op, String key) {
         // TO DO
        return null;
    }

}
