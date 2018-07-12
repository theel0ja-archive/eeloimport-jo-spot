package io.eelo.spot.autocompleter;

import io.eelo.spot.TestUtils;
import io.eelo.spot.data.Params;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DBpediaTest {

    @Test
    public void search() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "hell");
        final List<String> result = new DBpedia().search(params);
        System.out.println(result);
    }
}