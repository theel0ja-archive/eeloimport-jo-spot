package io.eelo.spot.engines;

import io.eelo.spot.data.Result;
import io.eelo.spot.data.SearchQuery;
import io.eelo.spot.search.Request;
import io.eelo.spot.search.ResultContainer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ArchLinux extends Engine {

    private final String[] languages = new String[]{
            "ar:العربية",
            "bg:Български",
            "cs:Česky",
            "da:Dansk",
            "el:Ελληνικά",
            "es:Español",
            "he:עברית",
            "hr:Hrvatski",
            "hu:Magyar",
            "it:Italiano",
            "ko:한국어",
            "lt:Lietuviškai",
            "nl:Nederlands",
            "pl:Polski",
            "pt:Português",
            "ru:Русский",
            "sl:Slovenský",
            "th:ไทย",
            "uk:Українська",
            "zh:简体中文"};

    protected ArchLinux(String id) {
        super(id, true, false, true, "arch linux wiki", "it");
    }

    private String parseLanguage(final SearchQuery searchQuery) {
        final String language = searchQuery.getLanguage().split("-")[0];

        for (String result : languages) {
            if (result.startsWith(language)) {
                return result.substring(3);
            }
        }
        return null;
    }


    @Override
    public void initSupportedLanguages() {
        supportedLanguages.add("en");
    }

    @Override
    public Request prepareRequest(SearchQuery searchQuery) {
        return new Request("ok");
    }

    @Override
    public ResultContainer initResults(String message, SearchQuery searchQuery) {
        final Document doc = Jsoup.parse(message);
        final Elements elements = doc.select(".mw-search-results");
        final ResultContainer result = new ResultContainer();
        elements.stream().map(element -> parseElement(element, searchQuery)).forEach(result::extend);
        return result;
    }

    private Result parseElement(Element element, SearchQuery searchQuery) {
        final Element titleNode = element.select(".mw-search-result-heading").get(0).child(0);
        return new Result("", "", "");
    }
}
