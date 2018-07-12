package io.eelo.spot.autocompleter;

import io.eelo.spot.data.Params;
import io.eelo.spot.search.Request;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.parsers.DocumentBuilderFactory.newInstance;

public class Google extends Autocompleter {

    Google() {
        super("google");
    }

    @Override
    public List<String> search(Params params) throws IOException, ParserConfigurationException, SAXException {
        final String query = URLEncoder.encode(params.getQuery());
        final String language = URLEncoder.encode(params.getLanguage());

        final Request request = new Request("https://suggestqueries.google.com/complete/search?client=toolbar&hl=" + language + "&q=" + query);
        final InputStream inputStream = request.sendRequest();
        final Document document = newInstance().newDocumentBuilder().parse(inputStream);

        final List<String> result = new ArrayList<>();

        final NodeList suggestions = document.getElementsByTagName("suggestion");
        for (int i = 0; i < suggestions.getLength(); i++) {
            result.add(((Element) suggestions.item(i)).getAttribute("data"));
        }
        return result;
    }
}
