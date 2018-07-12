package io.eelo.spot.autocompleter;

import io.eelo.spot.data.Params;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public abstract class Autocompleter {

    private final String name;

    Autocompleter(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public abstract List<String> search(final Params params) throws IOException, ParserConfigurationException, SAXException;
}
