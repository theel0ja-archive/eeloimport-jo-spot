package io.eelo.spot.data;

import io.eelo.spot.translator.LanguageFinder;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Params {

    private String query = "";
    private String category = "general";
    private int pageno = 1;
    private String timerange = "None";
    private String language = null;
    private String enginesID = "";
    private int safesearch = 2;
    private boolean resultsOneNewTab = false;
    private boolean openAccessDOIRewrite = true;
    private String autocompleter = "duckduckgo";

    public static Params init(final ServletRequest request) {
        final Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        final Params result = new Params();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                result.setParameter(cookie.getName(), cookie.getValue());
            }
        }
        request.getParameterMap().forEach((o, o1) -> {
            final String name = (String) o;
            final String[] values = (String[]) o1;
            result.setParameter(name, values[0]);
        });

        if (result.language == null) {
            final String header = ((HttpServletRequest) request).getHeader("Accept-Language");
            result.language = LanguageFinder.fromHeader(header);
        }
        if (result.language == null) {
            result.language = "en";
        }

        return result;
    }

    private void setParameter(final String name, final String value) {
        switch (name) {
            case "q":
                query = value;
                break;
            case "category":
                category = value;
                break;
            case "pageno":
                pageno = Integer.parseInt(value);
                break;
            case "time_range":
                timerange = value;
                break;
            case "enginesID":
                enginesID = value;
                break;
            case "language":
                language = value;
                break;
            case "safesearch":
                safesearch = Integer.parseInt(value);
                break;
            case "autocompleter":
                autocompleter = value;
            case "results_on_new_tab":
                resultsOneNewTab = value.equals("on");
            case "open_access_doi_rewrite":
                openAccessDOIRewrite = value.equals("on");
        }
    }

    public String getQuery() {
        return query;
    }

    public String getEnginesID() {
        return enginesID;
    }

    public String getLanguage() {
        return language;
    }

    public int getSafesearch() {
        return safesearch;
    }

    public String getCategory() {
        return category;
    }

    public int getPageno() {
        return pageno;
    }

    public String getTimerange() {
        return timerange;
    }

    public boolean isResultsOneNewTab() {
        return resultsOneNewTab;
    }

    public boolean isOpenAccessDOIRewrite() {
        return openAccessDOIRewrite;
    }

    public String getAutocompleter() {
        return autocompleter;
    }

    public SearchQuery generateSearchQuery() {
        return new SearchQuery(query, category, pageno, timerange, language, safesearch);
    }
}