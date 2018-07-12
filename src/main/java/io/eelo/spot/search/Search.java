package io.eelo.spot.search;

import io.eelo.spot.data.Preferences;
import io.eelo.spot.data.SearchQuery;
import io.eelo.spot.engines.Engine;
import io.eelo.spot.threadPool.ThreadPool;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Search {

    private final ResultContainer resultContainer = new ResultContainer();
    private final SearchQuery query;
    private final String engines;

    public Search(final SearchQuery searchQuery, final String engines) {
        this.query = searchQuery;
        this.engines = engines;
    }

    public void search() {
        final Stream<Engine> engines = splitAllTwoChars(this.engines)
                .map(Preferences.enginesById::get)
                .filter(engine -> engine.isPagingSupported() || query.getPageno() == 0)
                .filter(engine -> engine.isTimeRangeSupported() || query.getTimerange().equals("None"));

        searchMultipleEngine(engines);
    }

    private void searchMultipleEngine(Stream<Engine> engines) {
        engines.forEach(engine -> ThreadPool.run(() -> {
            try {
                final SearchElement element = engine.searchAndWait(query);
                element.addPopularity();
                this.resultContainer.extend(element.getResultContainer().get());
            } catch (ExecutionException | InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }));
    }

    private Stream<String> splitAllTwoChars(final String str) {
        return stream(str.split("(?<=\\G..)"));
    }
}
