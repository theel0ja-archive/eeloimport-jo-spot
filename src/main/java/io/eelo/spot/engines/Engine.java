package io.eelo.spot.engines;

import io.eelo.spot.dao.FileAccess;
import io.eelo.spot.data.SearchQuery;
import io.eelo.spot.search.Request;
import io.eelo.spot.search.ResultContainer;
import io.eelo.spot.search.SearchElement;
import io.eelo.spot.search.SearchEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

public abstract class Engine {

    public final List<SearchElement> searchHistory = new ArrayList<>();
    private final String id;
    private final boolean supportPaging;
    private final boolean supportTimeRange;
    private final boolean supportLanguage;
    private final String name;
    private final String[] categories;
    protected final List<String> supportedLanguages = new ArrayList<>();

    Engine(final String id, final boolean supportPaging, final boolean supportTimeRange, final boolean supportLanguage, final String name, final String... categories) {
        this.id = id;
        this.supportPaging = supportPaging;
        this.supportTimeRange = supportTimeRange;
        this.supportLanguage = supportLanguage;
        this.name = name;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isPagingSupported() {
        return supportPaging;
    }


    public boolean isTimeRangeSupported() {
        return supportTimeRange;
    }

    public boolean doesSupportLanguage(final String language) {
        return supportLanguage && supportedLanguages.contains(language);
    }

    public String[] getCategories() {
        return categories;
    }

    public abstract void initSupportedLanguages();

    public abstract Request prepareRequest(final SearchQuery searchQuery);

    public abstract ResultContainer initResults(final String message, final SearchQuery searchQuery);


    public void prepareSearch(final SearchQuery searchQuery) {
        if (!alreadySearched(searchQuery)) {
            final FutureTask<ResultContainer> future = new FutureTask<>(new SearchEngine(searchQuery, this));
            searchHistory.add(new SearchElement(searchQuery, future));
            future.run();
        }
    }

    private boolean alreadySearched(final SearchQuery searchQuery) {
        return findSearch(searchQuery) != null || FileAccess.exist(searchQuery, this);
    }

    private SearchElement findSearch(final SearchQuery searchQuery) {
        return searchHistory.stream().filter(searchElement -> searchElement.getSearchQuery().equals(searchQuery)).findFirst().orElse(null);
    }

    public SearchElement searchAndWait(final SearchQuery searchQuery) throws IOException {
        final SearchElement searchElement = findSearch(searchQuery);
        if (searchElement != null) {
            return searchElement;
        }
        final SearchElement read = FileAccess.read(searchQuery, this);
        if (read != null) {
            searchHistory.add(read);
            return read;
        }
        final FutureTask<ResultContainer> future = new FutureTask<>(new SearchEngine(searchQuery, this));
        final SearchElement element = new SearchElement(searchQuery, future);
        searchHistory.add(element);
        future.run();
        return element;
    }
}
