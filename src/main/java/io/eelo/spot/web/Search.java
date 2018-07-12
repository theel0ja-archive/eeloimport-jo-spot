package io.eelo.spot.web;

import io.eelo.spot.answerers.Answerers;
import io.eelo.spot.data.Params;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Search extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final Params params = (Params) req.getAttribute("params");
        final List<String> answers = Answerers.callAll(params);
        resp.getWriter().print("{\"answers\":[\"ok\",\"ok\"],\"corrections\":[\"salut\"],\"infoboxes\":[\"an infobox\"],\"results\":[\"my result\"]}");
    }
}
