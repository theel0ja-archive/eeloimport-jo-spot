<jsp:useBean id="t" scope="request" type="io.eelo.spot.web.Translator"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="io.eelo.spot.data.Preferences" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="eelo spot"/>
    <meta name="keywords" content="eelo, spot, search, search engine, metasearch, meta search"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="generator" content="eelo/1">
    <meta name="referrer" content="no-referrer">
    <meta name="viewport" content="width=device-width, initial-scale=1 , maximum-scale=1.0, user-scalable=1"/>
    <title>eelo</title>
    <link rel="shortcut icon" href="/favicon.ico">
    <link rel="stylesheet" href="/css/eelo.min.css">
    <link rel="stylesheet" href="/css/utils.css">
    <style>
        #tab_general_r:checked ~ #tabs > label[for="tab_general_r"] {
            font-weight: bold;
        }

        #tab_engines_r:checked ~ #tabs > label[for="tab_engines_r"] {
            font-weight: bold;
        }

        #tab_info_r:checked ~ #tabs > label[for="tab_info_r"] {
            font-weight: bold;
        }
    </style>
</head>
<body>
<svg class="icons" id="icons" width="0" height="0">
    <g id="checkbox_checked">
        <path d="M19 3H5c-1.11 0-2 .9-2 2v14c0 1.1.89 2 2 2h14c1.11 0 2-.9 2-2V5c0-1.1-.89-2-2-2zm-9 14l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z"></path>
    </g>
    <g id="checkbox_unchecked">
        <path d="M19 5v14H5V5h14m0-2H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2z"></path>
    </g>
</svg>
<%@include file="topbar.jsp" %>

<div class="container noselect">
    <h1>${t.t("preferences")}</h1>
</div>
<div id="preferences" class="container">

    <div id="controls">
        <input type="radio" class="tab-radio" id="tab_general_r" value="general" name="tab" checked>
        <div id="tab_general" class="tab-content">
            <fieldset>
                <div class="preference inline">
                    <div>
                        <label>${t.t("Search language")}</label>
                        <div class="help-block text-muted">${t.t("What language do you prefer for search?")}</div>
                    </div>
                    <div><select class="custom-select" id="language">
                        <c:forEach items="${Preferences.languages}" var="language">
                            <option value="${language.key}">${language.value}</option>
                        </c:forEach>
                    </select></div>
                </div>
                <div class="preference inline">
                    <div>
                        <label>${t.t("Interface language")}</label>
                        <div class="help-block text-muted">${t.t("Change the language of the layout")}</div>
                    </div>
                    <div><select class="custom-select" id="locale">
                        <c:forEach items="${Preferences.locales}" var="locale">
                            <option value="${locale.key}">${locale.value}</option>
                        </c:forEach>
                    </select></div>
                </div>
                <div class="preference inline">
                    <div>
                        <label>${t.t("Autocomplete")}</label>
                        <div class="help-block text-muted">${t.t("Find stuff as you type")}</div>
                    </div>
                    <div><select class="custom-select" id="autocompleter">
                        <option value="none">${t.t("None")}</option>
                        <option value="google">Google</option>
                        <option value="duckduckgo">Duckduckgo</option>
                        <option value="qwant">Qwant</option>
                        <option value="wikipedia">Wikipedia</option>
                        <option value="dbpedia">Dbpedia</option>
                        <option value="startpage">Startpage</option>
                    </select></div>
                </div>
                <div class="preference inline">
                    <div>
                        <label>${t.t("Image proxy")}</label>
                        <div class="help-block text-muted">${t.t("Proxying image results through eelo")}</div>
                    </div>
                    <div><select class="custom-select" id="image_proxy">
                        <option value="true">${t.t("Enabled")}</option>
                        <option value="false">${t.t("Disabled")}</option>
                    </select></div>
                </div>
                <div class="preference inline">
                    <div>
                        <label>${t.t("SafeSearch")}</label>
                        <div class="help-block text-muted">${t.t("Filter content")}</div>
                    </div>
                    <div><select class="custom-select" id="safesearch">
                        <option value="2">${t.t("Strict")}</option>
                        <option value="1">${t.t("Moderate")}</option>
                        <option value="0">${t.t("Disabled")}</option>
                    </select></div>
                </div>
                <div class="preference inline">
                    <div>
                        <label>${t.t("Results on new tabs")}</label>
                        <div class="help-block text-muted">${t.t("Open result links on new browser tabs")}</div>
                    </div>
                    <div><select class="custom-select" id="results_on_new_tab">
                        <option value="on">${t.t("On")}</option>
                        <option value="off">${t.t("Off")}</option>
                    </select></div>
                </div>
                <div class="preference inline">
                    <div>
                        <label>${t.t("Open Access DOI rewrite")}</label>
                        <div class="help-block text-muted">${t.t("Avoid paywalls by redirecting to open-access versions of publications when available")}</div>
                    </div>
                    <div><select class="custom-select" id="open_access_doi_rewrite">
                        <option value="on">${t.t("On")}</option>
                        <option value="off">${t.t("Off")}</option>
                    </select></div>
                </div>
            </fieldset>
        </div>


        <input type="radio" class="tab-radio" id="tab_engines_r" value="engines" name="tab">
        <div id="tab_engines" class="tab-content">
            <c:forEach items="${Preferences.categories}" var="category">
                <section id="engines">
                    <h3>${t.t(category)}</h3>
                    <c:forEach items="${Preferences.enginesByCategory.get(category)}" var="engine">
                        <div class="engine">
                            <input class="checkmark_input onoffswitch-checkbox" type="checkbox" id="${engine.id}"
                                   name="${engine.id}">
                            <label for="${engine.id}" class="checkmark">
                                <svg class="icon checked" width="24px" height="24px">
                                    <use href="#checkbox_checked" xlink:href="#checkbox_checked"></use>
                                </svg>
                                <svg class="unchecked" width="24px" height="24px">
                                    <use href="#checkbox_unchecked" xlink:href="#checkbox_unchecked"></use>
                                </svg>
                            </label>
                        </div>
                        <span class="data">
                    <b>${engine.name}</b>
                </span>
                    </c:forEach>
                </section>
            </c:forEach>
        </div>


        <input type="radio" class="tab-radio" id="tab_info_r" value="info" name="tab">
        <div id="tab_info" class="tab-content">
            <section id="answerers">
                <h3 class="noselect">${t.t("Answerers")}</h3>
                <p>${t.t("This is the list of eelo\'s instant answering modules.")}</p>
                <ul>
                    <c:forEach items="${Preferences.answerers}" var="answerer">
                        <li>
                            <p><b>${t.t(answerer.name)}</b>
                                <i>${t.t("Keywords")}: ${fn:join(answerer.keyWorlds, ", ")}</i>
                            </p>
                            <p>${t.t(answerer.description)}</p>
                            <div>
                                <b>${t.t("Examples")}</b>
                                <p>${t.t(answerer.example)}</p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </section>

            <section id="cookies">
                <h3 class="noselect">${t.t("Cookies")}</h3>
                <p>
                    ${t.t("This is the list of cookies and their values eelo is storing on your computer.")}<br/>
                        ${t.t("With that list, you can assess eelo transparency.")}<br/>
                </p>
                <ul id="cookies_list" class="noselect"></ul>
                <div style="display: none" id="no_cookie">
                    ${t.t("currently, there are no cookies defined.")}
                </div>
            </section>
        </div>


        <div id="tabs" class="noselect">
            <label for="tab_general_r" class="pointer">${t.t("General")}</label>
            <label for="tab_engines_r" class="pointer">${t.t("Engines")}</label>
            <label for="tab_info_r" class="pointer">${t.t("Informations")}</label>
        </div>
    </div>


    <div id="info">
        <div id="notice">
            <p>${t.t("These settings are stored in your cookies, this allows us not to store this data about you.")}
                <br/>
                ${t.t("These cookies serve your sole convenience, we don\'t use these cookies to track you.")}
            </p>
        </div>

        <div>
            <p>${t.t("Search URL of the currently saved preferences")}
                <small class="text-muted">
                    (${t.t("Note: specifying custom settings in the search URL can reduce privacy by leaking data to the clicked result sites.")})
                </small>
                :<br/>
            </p>
            <input readonly="" class="select-all-on-click block" type="url"
                   value="https://spot.eelo.me/?preferences=asd&q=%s">
        </div>

        <section id="action_buttons" class="noselect">
            <div>
                <input type="submit" class="btn btn-block pointer" value="${t.t("save")}"
                       onclick="save();document.location='/'"/>
                <a href="/" class="btn btn-block">${t.t("back")}</a>
            </div>
            <button onclick="removeCookies();document.location = '/'" class="btn btn-block danger pointer">
                ${t.t("Reset defaults")}
            </button>
        </section>
    </div>
</div>
</body>
</html>
<script src="/js/preferences.js"></script>