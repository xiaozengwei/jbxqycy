package com.gx.core.dbmigrate;

import java.util.Collection;
import java.util.Properties;

import javax.annotation.PostConstruct;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseMigrator {
    private static Logger logger = LoggerFactory
            .getLogger(DatabaseMigrator.class);
    private DataSource dataSource;
    private Properties applicationProperties;

    @PostConstruct
    public void execute() {
        if (!"true".equals(applicationProperties
                .getProperty("dbmigrate.enable"))) {
            logger.info("skip dbmigrate");

            return;
        }

        if ("true".equals(applicationProperties.getProperty("dbmigrate.clean"))) {
            logger.info("clean database");

            Flyway flyway = new Flyway();
            flyway.setDataSource(dataSource);
            flyway.clean();
        }

        Collection<DatabaseMigrateInfo> databaseMigrateInfos = new DatabaseMigrateInfoBuilder(
                applicationProperties).build();

        for (DatabaseMigrateInfo databaseMigrateInfo : databaseMigrateInfos) {
            if (!databaseMigrateInfo.isEnabled()) {
                logger.info("skip migrate : {}, {}, {}",
                        databaseMigrateInfo.getName(),
                        databaseMigrateInfo.getTable());

                continue;
            }

            logger.info("migrate : {}, {}, {}", databaseMigrateInfo.getName(),
                    databaseMigrateInfo.getTable());

            Flyway flyway = new Flyway();
            flyway.setPlaceholderPrefix("$${");
            flyway.setInitOnMigrate(true);
            flyway.setInitVersion("0");
            flyway.setDataSource(dataSource);
            flyway.setTable(databaseMigrateInfo.getTable());
            flyway.setLocations(new String[] { databaseMigrateInfo
                    .getLocation() });
            flyway.migrate();
        }
    }

    public void setApplicationProperties(Properties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
