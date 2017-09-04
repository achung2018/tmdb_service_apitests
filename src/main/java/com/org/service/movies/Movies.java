package com.org.service.movies;

import com.org.service.ServiceTestBase;
import com.org.util.ApiMapper;
import com.org.util.PropertiesLoader;

public class Movies extends ServiceTestBase {
    private String moviesRequestPath;
    private final String moviesPathParam = "/{movie_id}";

    public Movies() {
        super(PropertiesLoader.getBasePath(),System.getProperty("apikey"));
    }

    @Override
    public String configRequestPath(String op, String key) {
        moviesRequestPath = getServiceUrl() + PropertiesLoader.getApiPath("movies.path") + moviesPathParam +
                      ApiMapper.getMoviesEndpoint(op,key);
        return moviesRequestPath;
    }

}
