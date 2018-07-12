package io.eelo.spot.autocompleter;

import io.eelo.spot.data.Params;
import io.eelo.spot.search.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Qwant extends Autocompleter {

    Qwant() {
        super("qwant");
    }

    @Override
    public List<String> search(Params params) throws IOException {
        final String query = URLEncoder.encode(params.getQuery());
        final String language = URLEncoder.encode(params.getLanguage());

        final Request request = new Request("https://api.qwant.com/api/suggest?q=" + query + "&lang=" + language);

        final JSONArray jsonArray = new JSONObject(request.sendRequestToString())
                .getJSONObject("data")
                .getJSONArray("items");

        final List<String> result = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            result.add(jsonArray.getJSONObject(i).getString("value"));
        }
        return result;
    }
}
