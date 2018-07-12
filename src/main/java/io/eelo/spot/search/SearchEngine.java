package io.eelo.spot.search;

import io.eelo.spot.data.SearchQuery;
import io.eelo.spot.engines.Engine;

import java.io.IOException;
import java.util.concurrent.Callable;

public class SearchEngine implements Callable<ResultContainer> {

    private final SearchQuery searchQuery;
    private final Engine engine;

    public SearchEngine(final SearchQuery searchQuery, Engine engine) {
        this.searchQuery = searchQuery;
        this.engine = engine;
    }

    @Override
    public ResultContainer call() throws IOException {
        final String result = engine.prepareRequest(searchQuery).sendRequestToString();
        return engine.initResults(result, searchQuery);
    }
}
