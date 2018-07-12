package io.eelo.spot.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class ImageProxy extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String url = req.getReader().readLine();
        final URLConnection connection = new URL(url).openConnection();

        final InputStream input = connection.getInputStream();
        final ServletOutputStream output = resp.getOutputStream();
        send(input, output);

    }

    private void send(final InputStream input, final OutputStream output) throws IOException {
        while (true) {
            final int b = input.read();
            if (b < 0) {
                return;
            }
            output.write(b);
        }
    }
}
