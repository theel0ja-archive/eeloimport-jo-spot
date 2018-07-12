package io.eelo.spot.autocompleter;

import io.eelo.spot.TestUtils;
import io.eelo.spot.data.Params;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GoogleTest {

    @Test
    public void search() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "hell");
        TestUtils.accessToPrivateField(params, "language", "en-US");
        final List<String> result = new Google().search(params);
        System.out.println(result);
    }

    @Test
    public void searchInFrench() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "sal");
        TestUtils.accessToPrivateField(params, "language", "fr");
        final List<String> result = new Google().search(params);
        System.out.println(result);
    }
}