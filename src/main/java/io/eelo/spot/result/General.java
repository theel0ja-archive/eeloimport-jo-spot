package io.eelo.spot.result;

public class General extends Result {

    private final String url;
    private final String title;
    private final String description;

    public General(final String url, final String title, final String description) {
        this.url = url;
        this.title = title;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
