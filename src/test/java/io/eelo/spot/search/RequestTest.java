package io.eelo.spot.search;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class RequestTest {

    @Test
    public void stringOfInputStream() throws IOException {
        final InputStream inputStream = new ByteArrayInputStream("asd".getBytes());
        final String result = new Request("").toString(inputStream);
        assertEquals("asd", result);
    }
}