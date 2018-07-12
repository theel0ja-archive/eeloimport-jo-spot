package io.eelo.spot.result;

import java.util.Date;

public abstract class Result {

    public String getUrl() {
        return "";
    }

    public String getTitle() {
        return "";
    }

    public String getDescription() {
        return "";
    }

    public String getImage_src() {
        return "";
    }

    public String getThunbnail_src() {
        return "";
    }

    public Date getPublished_date() {
        return new Date(0);
    }

    public String getLongitude() {
        return "";
    }

    public String getLatitude() {
        return "";
    }

    public String getBoundingbox() {
        return "";
    }

    public String getGeojson() {
        return "";
    }

    public String getAddress() {
        return "";
    }

    public String getOsm() {
        return "";
    }

}
