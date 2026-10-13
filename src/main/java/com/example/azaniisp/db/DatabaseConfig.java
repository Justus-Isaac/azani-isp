package com.example.azaniisp.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class DatabaseConfig {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = DatabaseConfig.class.getResourceAsStream("/db.properties")) {
            if (in == null) throw new IllegalStateException("db.properties not found on classpath");
            props.load(in);
        }  catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String get(String key) {
        String env = System.getenv(key.replace('.', '_').toUpperCase());
        return env != null ? env : props.getProperty(key);
    }
}
