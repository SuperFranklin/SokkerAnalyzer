package com.slupski.database;

import com.slupski.commons.Settings;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DataBaseMigrationStarter {

    @Autowired
    Settings settings;

    @PostConstruct
    private void migrate(){
        String url = settings.getDatabaseUrl();
        String user = settings.getDatabaseUser();
        String password = settings.getDatabasePassword();
        String schema = settings.getDatabaseSchema();

        Flyway flyway = Flyway.configure().dataSource(url, user, password).schemas(schema).load();
        flyway.migrate();
    }
}
