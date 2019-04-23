package com.slupski.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class Settings {

    private static final String DATABASE_URL = "database.url";
    private static final String DATABASE_USER = "database.user";
    private static final String DATABASE_PASSWORD = "database.password";
    private static final String DATABASE_SCHEMA = "database.schema";
    private static final String BASIC_AUTH_USER = "basicauth.user";
    private static final String BASIC_AUTH_PASSWORD = "basicauth.password";


    @Autowired
    Environment environment;

    public String getDatabaseUrl(){
        return environment.getProperty(DATABASE_URL);
    }

    public String getDatabaseUser(){
        return environment.getProperty(DATABASE_USER);
    }

    public String getDatabasePassword(){
        return environment.getProperty(DATABASE_PASSWORD);
    }

    public String getDatabaseSchema(){
        return environment.getProperty(DATABASE_SCHEMA);
    }

    public String getBasicAuthUser(){
        return environment.getProperty(BASIC_AUTH_USER);
    }

    public String getBasicAuthPassword(){
        return environment.getProperty(BASIC_AUTH_PASSWORD);
    }
}

