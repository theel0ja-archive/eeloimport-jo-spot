package io.eelo.spot.autocompleter;

import io.eelo.spot.data.Params;
import io.eelo.spot.search.Request;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.parsers.DocumentBuilderFactory.newInstance;

public class DBpedia extends Autocompleter {

    DBpedia() {
        super("dbpedia");
    }

    @Override
    public List<String> search(Params params) throws IOException, ParserConfigurationException, SAXException {
        final String query = URLEncoder.encode(params.getQuery());

        final Request request = new Request("http://lookup.dbpedia.org/api/search.asmx/KeywordSearch?QueryString=" + query);
        final Document document = newInstance().newDocumentBuilder().parse(request.sendRequest());

        final List<String> result = new ArrayList<>();

        final NodeList results = document.getElementsByTagName("Result");
        for (int i = 0; i < results.getLength(); i++) {
            result.add(((Element) results.item(i)).getElementsByTagName("Label").item(0).getTextContent());
        }
        return result;
    }
}
