package io.eelo.spot.translator;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {

    static final Map<String, Map<String, String>> translations = new HashMap<>();
    private final String language;

    Translator(String language) {
        this.language = language;
    }

    static void init(String language) {
        final InputStream file = Translator.class.getClassLoader().getResourceAsStream("translations/" + language + ".txt");
        final Map<String, String> languageTranslations = new HashMap<>();

        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            final String[] translation = line.split(" = ");
            languageTranslations.put(translation[0], translation[1]);
        }
        translations.put(language, languageTranslations);
    }

    public String t(String text) {
        final String result = translations.get(language).get(text);
        return result == null ? text : result;
    }

    String getLanguage() {
        return language;
    }
}
