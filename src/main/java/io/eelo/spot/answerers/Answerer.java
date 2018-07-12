package io.eelo.spot.answerers;

import io.eelo.spot.data.Params;

public interface Answerer {

    String[] getKeyWorlds();

    boolean match(final Params params);

    String call(final Params params);

    String getName();

    String getDescription();

    String getExample();

}
