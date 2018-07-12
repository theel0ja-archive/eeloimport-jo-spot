package io.eelo.spot.dao;

import io.eelo.spot.data.Preferences;
import io.eelo.spot.engines.Engine;
import io.eelo.spot.search.SearchElement;
import io.eelo.spot.threadPool.InfiniteLoop;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class FileSearch extends InfiniteLoop implements ServletContextListener {

    public static int minPopularityCache;
    public static int minPopularityFiles;
    public static long keepInCacheAfterCreated;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        new Thread(this).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void loop() {
        Preferences.enginesById.values().forEach(engine -> {
            for (int i = 0; i < engine.searchHistory.size(); i++) {
                action(engine.searchHistory.get(i), engine);
            }
        });
    }

    private void action(final SearchElement searchElement, final Engine engine) {
        try {
            if (keepInFiles(searchElement)) {
                FileAccess.save(searchElement, engine);
            }
            if (!keepInCache(searchElement)) {
                engine.searchHistory.remove(searchElement);
            }
        } catch (ExecutionException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private boolean keepInCache(final SearchElement searchElement) {
        return searchElement.getPopularity() > minPopularityCache || !timeoutCache(searchElement);
    }

    private boolean keepInFiles(final SearchElement searchElement) {
        return searchElement.getPopularity() > minPopularityFiles;
    }

    private boolean timeoutCache(final SearchElement element) {
        return System.currentTimeMillis() - element.getCreatedTime() - keepInCacheAfterCreated > 0;
    }
}
