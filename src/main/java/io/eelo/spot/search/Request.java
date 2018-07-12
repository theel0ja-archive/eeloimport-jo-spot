package io.eelo.spot.search;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class Request {

    private final Map<String, String> headers = new HashMap<>();
    private String url = "";

    public Request(final String url) {
        this.url = url;
    }

    public InputStream sendRequest() throws IOException {
        final URLConnection conn = new URL(url).openConnection();
        headers.forEach(conn::setRequestProperty);
        conn.setRequestProperty("User-Agent", UserAgent.generate());
        conn.connect();
        return conn.getInputStream();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void putHeader(final String name, final String value) {
        headers.put(name, value);
    }

    public String toString(final InputStream input) throws IOException {
        final StringBuilder builder = new StringBuilder();
        while (true) {
            final int read = input.read();
            if (read < 0) {
                return builder.toString();
            }
            builder.append((char) read);
        }
    }

    public String sendRequestToString() throws IOException {
        return toString(sendRequest());
    }
}
