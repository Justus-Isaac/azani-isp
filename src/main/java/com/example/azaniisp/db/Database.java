package com.example.azaniisp.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public final class Database {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DatabaseConfig.get("db.url"));
        config.setUsername(DatabaseConfig.get("db.username"));
        config.setPassword(DatabaseConfig.get("db.password"));
        config.setMaximumPoolSize(Integer.parseInt(DatabaseConfig.get("db.pool.maximumPoolSize")));
        config.setMinimumIdle(Integer.parseInt(DatabaseConfig.get("db.pool.minimumIdle")));
        config.setConnectionTimeout(Long.parseLong(DatabaseConfig.get("db.pool.connectionTimeoutMs")));

        dataSource = new HikariDataSource(config);
    }

    private Database() {}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void shutdown() {
        dataSource.close();
    }
}
