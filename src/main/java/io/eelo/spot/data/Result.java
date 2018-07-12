package io.eelo.spot.data;

import java.util.Date;

public class Result {

    private final String url;
    private final String title;
    private final String description;
    private final String image_src;
    private final String thunbnail_src;
    private final Date published_date;
    private final String longitude;
    private final String latitude;
    private final String boundingbox;
    private final String geojson;
    private final String address;
    private final String osm;

    public Result(final String url, final String title, final String description) {
        this(url, title, description, null, null, null, null, null, null, null, null, null);
    }

    public Result(final String url, final String title, final String description, final String image_src, final String thunbnail_src) {
        this(url, title, description, image_src, thunbnail_src, null, null, null, null, null, null, null);
    }

    public Result(final String url, final String title, final String description, final String image_src,
                  final String thunbnail_src, final Date published_date, final String longitude, final String latitude,
                  final String boundingbox, final String geojson, final String address, final String osm) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.image_src = image_src;
        this.thunbnail_src = thunbnail_src;
        this.published_date = published_date;
        this.longitude = longitude;
        this.latitude = latitude;
        this.boundingbox = boundingbox;
        this.geojson = geojson;
        this.address = address;
        this.osm = osm;
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

    public Date getPublished_date() {
        return published_date;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getBoundingbox() {
        return boundingbox;
    }

    public String getGeojson() {
        return geojson;
    }

    public String getAddress() {
        return address;
    }

    public String getOsm() {
        return osm;
    }
}
