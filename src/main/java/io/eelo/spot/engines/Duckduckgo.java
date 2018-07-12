package io.eelo.spot.engines;

import io.eelo.spot.data.Result;
import io.eelo.spot.data.SearchQuery;
import io.eelo.spot.search.Request;
import io.eelo.spot.search.ResultContainer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Duckduckgo extends Engine {

    private Duckduckgo(String id) {
        super(id, true, true, true, "duckduckgo");
    }


    @Override
    public ResultContainer initResults(final String message, final SearchQuery searchQuery) {
        final Document doc = Jsoup.parse(message);
        final Elements elements = doc.select(".result.results_links.results_links_deep.web-result");
        final ResultContainer result = new ResultContainer();
        elements.stream().map(this::parseElement).forEach(result::extend);
        return result;
    }

    @Override
    public void initSupportedLanguages() {
        supportedLanguages.add("en");
    }

    @Override
    public Request prepareRequest(SearchQuery searchQuery) {
        if (!Arrays.asList("-", "d", "w", "m").contains(searchQuery.getTimerange())) {
            return null;
        }
        return new Request("https://duckduckgo.com/html?{query}&s={offset}&dc={dc_param}");
    }

    private Result parseElement(Element element) {
        final Elements titleNode = element.select(".result__a");
        final String url = titleNode.attr("href");
        final String title = titleNode.text();
        final String description = element.select(".result__snippet").text();

        return new Result(url, title, description);
    }
}
