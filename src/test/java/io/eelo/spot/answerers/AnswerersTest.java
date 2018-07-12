package io.eelo.spot.answerers;

import io.eelo.spot.TestUtils;
import io.eelo.spot.data.Params;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnswerersTest {


    @Test
    public void testSum() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "sum 55 0");
        final List<String> strings = Answerers.callAll(params);
        assertEquals(strings, Collections.singletonList("55"));
    }

    @Test
    public void testProd() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "prod 55 0");
        final List<String> strings = Answerers.callAll(params);
        assertEquals(strings, Collections.singletonList("0"));
    }

    @Test
    public void testRandom() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "random");
        final List<String> strings = Answerers.callAll(params);
        assertEquals(strings.size(), 1);
    }

    @Test
    public void testInvalidQuery() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "afsafdycy");
        final List<String> strings = Answerers.callAll(params);
        assertEquals(strings, Collections.emptyList());
    }

}