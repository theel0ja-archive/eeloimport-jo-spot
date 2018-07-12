package io.eelo.spot.autocompleter;

import io.eelo.spot.TestUtils;
import io.eelo.spot.data.Params;
import org.junit.Test;

import java.util.List;

public class DuckDuckGoTest {

    @Test
    public void search() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "hell");
        final List<String> result = new Duckduckgo().search(params);
        System.out.println(result);
    }
}