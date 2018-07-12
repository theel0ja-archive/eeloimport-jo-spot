package io.eelo.spot.answerers;

import io.eelo.spot.TestUtils;
import io.eelo.spot.data.Params;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatisticsTest {

    @Test
    public void min() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "min 100 10 82.54 -3 10");
        final String result = new Statistics().call(params);
        assertEquals("-3", result);
    }

    @Test
    public void max() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "max 100 10 82.54 -3 10");
        final String result = new Statistics().call(params);
        assertEquals("100", result);
    }

    @Test
    public void sum() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "sum 100 10 82.54 -3 10");
        final String result = new Statistics().call(params);
        assertEquals("199.54", result);
    }

    @Test
    public void avg() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "avg 100 10 82.54 -3 10");
        final String result = new Statistics().call(params);
        assertEquals("39.908", result);
    }

    @Test
    public void prod() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "prod 100 10 82.54 -3 10");
        final String result = new Statistics().call(params);
        assertEquals("-2476200.00", result);
    }

    @Test
    public void testCallingWithAWrongQuery() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "avg sum 54 89");
        assertFalse(new Statistics().match(params));
    }

    @Test
    public void testCallingWithWithWrongNumbers() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "sum 98.9.9 19.54");
        assertFalse(new Statistics().match(params));
    }

    @Test
    public void testCallingAGoodQuery() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "sum 98.9 19.54");
        assertTrue(new Statistics().match(params));
    }

}