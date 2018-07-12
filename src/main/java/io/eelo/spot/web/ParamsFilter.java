package io.eelo.spot.web;

import io.eelo.spot.data.Params;

import javax.servlet.*;
import java.io.IOException;

public class ParamsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            final Params params = Params.init(servletRequest);
            servletRequest.setAttribute("params", params);
        } catch (IllegalArgumentException e) {
            servletResponse.getWriter().println("Error : Illegal arguments");
        }

    }

    @Override
    public void destroy() {}
}
