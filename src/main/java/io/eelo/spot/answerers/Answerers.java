package io.eelo.spot.answerers;

import io.eelo.spot.data.Params;
import io.eelo.spot.data.Preferences;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Answerers {

    public static List<String> callAll(final Params params) {
        return Arrays.stream(Preferences.answerers).
                filter(answerer -> answerer.match(params)).
                map(answerer -> answerer.call(params)).
                filter(Objects::nonNull).
                collect(Collectors.toList());
    }
}
