package io.eelo.spot.search;

import io.eelo.spot.data.SearchQuery;

import java.util.concurrent.Future;

public class SearchElement {

    private int popularity;
    private final SearchQuery searchQuery;
    private final Future<ResultContainer> resultContainer;
    private final long createdTime;

    public SearchElement(SearchQuery searchQuery, Future<ResultContainer> resultContainer) {
        this(0, searchQuery, resultContainer, System.currentTimeMillis());
    }

    public SearchElement(final int popularity, final SearchQuery searchQuery, final Future<ResultContainer> resultContainer, final long createdTime) {
        this.popularity = popularity;
        this.searchQuery = searchQuery;
        this.resultContainer = resultContainer;
        this.createdTime = createdTime;
    }

    public int getPopularity() {
        return popularity;
    }

    public SearchQuery getSearchQuery() {
        return searchQuery;
    }

    public Future<ResultContainer> getResultContainer() {
        return resultContainer;
    }

    public void addPopularity() {
        popularity++;
    }

    public long getCreatedTime() {
        return createdTime;
    }
}
