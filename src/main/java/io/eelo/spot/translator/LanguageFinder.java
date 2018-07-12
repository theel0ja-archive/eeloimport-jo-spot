package io.eelo.spot.translator;

import io.eelo.spot.data.Preferences;

import java.util.Objects;

import static java.util.Arrays.stream;

public class LanguageFinder {


    private static String parseLanguage(String preferredLanguage) {
        final String language = removeQualityValue(preferredLanguage);
        if (existLanguage(language)) {
            return language;
        }
        final String withoutCountry = removeCountry(language);
        return existLanguage(withoutCountry) ? withoutCountry : null;
    }

    public static String fromHeader(String header) {
        final String[] preferredLanguages = header.split(",");
        return stream(preferredLanguages).map(LanguageFinder::parseLanguage).filter(Objects::nonNull).findFirst().orElse(null);
    }

    private static String removeCountry(String language) {
        final int i = language.indexOf('-');
        return i < 0 ? null : language.substring(0, i);
    }

    private static String removeQualityValue(String language) {
        final int i = language.indexOf(';');
        if (i < 0) {
            return language.replace(" ", "");
        }
        return language.substring(0, language.indexOf(';')).replace(" ", "");
    }

    private static boolean existLanguage(String language) {
        return stream(Preferences.locales).anyMatch(p -> p.getKey().equals(language));
    }

}
