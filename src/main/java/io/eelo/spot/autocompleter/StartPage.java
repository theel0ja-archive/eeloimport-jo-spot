package io.eelo.spot.autocompleter;

import io.eelo.spot.data.Params;
import io.eelo.spot.search.Request;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.net.URLEncoder.encode;

public class StartPage extends Autocompleter {

    StartPage() {
        super("startpage");
    }

    @Override
    public List<String> search(Params params) throws IOException {
        final Request request = new Request("https://startpage.com/do/suggest?query=" + encode(params.getQuery()));
        final String[] result = request.sendRequestToString().split("\n");
        return Arrays.asList(result);
    }
}
