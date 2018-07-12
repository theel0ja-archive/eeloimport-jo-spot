package io.eelo.spot.answerers;

import io.eelo.spot.TestUtils;
import io.eelo.spot.data.Params;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomTest {

    @Test
    public void aRandomInteger() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "random int");
        final String randomInteger = new Random().call(params);
        System.out.println("randomInteger = " + randomInteger);
    }

    @Test
    public void aRandomString() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "random string");
        final String randomString = new Random().call(params);
        System.out.println("randomString = " + randomString);
    }

    @Test
    public void aRandomFloat() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "random float");
        final String randomFloat = new Random().call(params);
        System.out.println("randomFloat = " + randomFloat);
    }

    @Test
    public void testCallingWithAWrongQuery() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "random double");
        assertFalse(new Random().match(params));
    }

    @Test
    public void testCallingWithAGoodQuery() throws Exception {
        final Params params = new Params();
        TestUtils.accessToPrivateField(params, "query", "random int");
        assertTrue(new Random().match(params));
    }


}