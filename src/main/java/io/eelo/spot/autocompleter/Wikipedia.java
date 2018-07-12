package io.eelo.spot.autocompleter;

import io.eelo.spot.data.Params;
import io.eelo.spot.search.Request;
import org.json.JSONArray;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.net.URLEncoder.encode;

public class Wikipedia extends Autocompleter {

    Wikipedia() {
        super("wikipedia");
    }

    @Override
    public List<String> search(Params params) throws IOException {
        final String lang = params.getLanguage().substring(0, 2);
        final Request request = new Request("https://" + lang + ".wikipedia.org/w/api.php?action=opensearch&search=" + encode(params.getQuery()) + "&limit=10&namespace=0&format=json");
        return new JSONArray(request.sendRequestToString())
                .getJSONArray(1)
                .toList().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
