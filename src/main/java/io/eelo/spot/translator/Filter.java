package io.eelo.spot.translator;

import io.eelo.spot.data.Params;

import javax.servlet.*;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String language = ((Params) servletRequest.getAttribute("params")).getLanguage();
        servletRequest.setAttribute("t", new Translator(language));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
