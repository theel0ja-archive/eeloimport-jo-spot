package io.eelo.spot.data;

public class SearchQuery {

    private final String query;
    private final String category;
    private final int pageno;
    private final String timerange;
    private final String language;
    private final int safesearch;

    public SearchQuery(String query, String category, int pageno, String timerange, String language, int safesearch) {
        this.query = query;
        this.category = category;
        this.pageno = pageno;
        this.timerange = timerange;
        this.language = language;
        this.safesearch = safesearch;
    }

    public String getQuery() {
        return query;
    }

    public String getCategory() {
        return category;
    }

    public int getPageno() {
        return pageno;
    }

    public String getTimerange() {
        return timerange;
    }

    public String getLanguage() {
        return language;
    }

    public int getSafesearch() {
        return safesearch;
    }
}
