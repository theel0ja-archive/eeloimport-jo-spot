package io.eelo.spot.autocompleter;

import io.eelo.spot.data.Preferences;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Autocompleters implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Preferences.autocompletersById.put("dbpedia", new DBpedia());
        Preferences.autocompletersById.put("duckduckgo", new Duckduckgo());
        Preferences.autocompletersById.put("google", new Google());
        Preferences.autocompletersById.put("qwant", new Qwant());
        Preferences.autocompletersById.put("startpage", new StartPage());
        Preferences.autocompletersById.put("wikipedia", new Wikipedia());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
