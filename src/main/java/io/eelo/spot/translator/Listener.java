package io.eelo.spot.translator;

import io.eelo.spot.data.Preferences;
import javafx.util.Pair;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        for (Pair locale : Preferences.locales) {
            final String language = (String) locale.getKey();
            final Map<String, String> translations = loadFile(language);
            Translator.translations.put(language, translations);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    private Map<String, String> loadFile(final String language) {
        final InputStream file = this.getClass().getClassLoader().getResourceAsStream("translations/" + language + ".txt");
        final Map<String, String> result = new HashMap<>();

        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            final String[] translation = line.split(" = ");
            result.put(translation[0], translation[1]);
        }
        scanner.close();
        return result;
    }
}
