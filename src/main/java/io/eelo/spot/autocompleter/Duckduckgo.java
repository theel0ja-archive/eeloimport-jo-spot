package io.eelo.spot.autocompleter;

import io.eelo.spot.data.Params;
import io.eelo.spot.search.Request;
import org.json.JSONArray;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

public class Duckduckgo extends Autocompleter {

    Duckduckgo() {
        super("duckduckgo");
    }

    @Override
    public List<String> search(final Params params) throws IOException {
        final String encode = URLEncoder.encode(params.getQuery());
        final Request request = new Request("https://ac.duckduckgo.com/ac?q=" + encode + "&type=list");
        final JSONArray result = new JSONArray(request.sendRequestToString());
        return result.getJSONArray(1).toList().stream().map(Object::toString).collect(Collectors.toList());
    }
}
