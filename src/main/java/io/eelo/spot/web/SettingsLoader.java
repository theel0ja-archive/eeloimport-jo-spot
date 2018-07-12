package io.eelo.spot.web;

import io.eelo.spot.dao.FileAccess;
import io.eelo.spot.dao.FileSearch;
import io.eelo.spot.search.UserAgent;
import io.eelo.spot.threadPool.InfiniteLoop;
import io.eelo.spot.threadPool.ThreadPool;
import org.json.JSONArray;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class SettingsLoader extends InfiniteLoop implements ServletContextListener {

    private final Properties properties = new Properties();
    private int reload;

    @Override
    public void loop() throws IOException {
        changeSettings();
        setInterval(reload * 1000);
    }

    private void changeSettings() throws IOException {
        properties.load(getClass().getClassLoader().getResourceAsStream("settings.properties"));
        FileSearch.minPopularityCache = loadInt("minPopularityCache");
        FileSearch.minPopularityFiles = loadInt("minPopularityFiles");
        FileSearch.keepInCacheAfterCreated = loadInt("keepInCacheAfterCreated");
        FileAccess.path = properties.getProperty("path");
        ThreadPool.init(loadInt("threadsPoolSize"));
        UserAgent.OSs = loadStringArray("OSs");
        UserAgent.versions = loadStringArray("Versions");
        reload = loadInt("reload");
    }

    private int loadInt(final String name) {
        return Integer.parseInt(properties.getProperty(name));
    }

    private List<String> loadStringArray(String name) {
        return new JSONArray(properties.getProperty(name)).toList().stream().map(Object::toString).collect(Collectors.toList());
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            changeSettings();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        stop();
    }
}
