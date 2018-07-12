package io.eelo.spot.result;

public class Image extends Result {

    private final String url;
    private final String title;
    private final String description;
    private final String image_src;
    private final String thunbnail_src;

    public Image(final String url, final String title, final String description, final String image_src, final String thunbnail_src) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.image_src = image_src;
        this.thunbnail_src = thunbnail_src;
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

    public String getImage_src() {
        return image_src;
    }

    public String getThunbnail_src() {
        return thunbnail_src;
    }
}
