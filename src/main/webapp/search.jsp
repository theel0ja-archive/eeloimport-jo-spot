<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="t" scope="request" type="io.eelo.spot.web.Translator"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<%@ include file="topbar.jsp" %>
<div id="search_bar_area">
    <form method="POST" action="/" id="search_form" class="inline-search" role="search">
        <div id="search_input_container">
            <a href="/" id="logo_link" class="noselect" ondragstart="return false"><img src="/favicon.ico" alt="" id="logo"></a>
            <input type="search" name="q" class="form-control" id="q" placeholder="${t.t("Search for...")}"
                   autocomplete="off" autofocus="autofocus" onfocus="this.select()">
            <span class="tt-dropdown-menu" style="display: none"></span>
            <button type="submit">
                <svg width="24px" height="24px">
                    <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                </svg>
            </button>
        </div>

        <div id="search_params">
            <div id="categories">
                <input class="hidden" id="checkbox_general" name="category" value="general" checked="checked"
                       type="radio">
                <label for="checkbox_general">general</label>
                <input class="hidden" id="checkbox_images" name="category" value="images" type="radio">
                <label for="checkbox_images">images</label>

                <div id="more_categories_container">
                    <input id="more_categories_toggle_" class="hidden"/>
                    <label id="show_more_categories_" for="more_categories_toggle_" class="pointer noselect">More</label>
                    <label id="show_less_categories_" for="more_categories_toggle_" class="hidden pointer noselect">Less</label>
                    <div id="more_categories">
                        <input class="hidden" id="checkbox_files" name="category" value="files" type="radio">
                        <label for="checkbox_files">files</label>
                        <input class="hidden" id="checkbox_it" name="category" value="it" type="radio">
                        <label for="checkbox_it">it</label>
                        <input class="hidden" id="checkbox_map" name="category" value="map" type="radio">
                        <label for="checkbox_map">map</label>
                        <input class="hidden" id="checkbox_music" name="category" value="music" type="radio">
                        <label for="checkbox_music">music</label>
                        <input class="hidden" id="checkbox_news" name="category" value="news" type="radio">
                        <label for="checkbox_news">news</label>
                        <input class="hidden" id="checkbox_science" name="category" value="science" type="radio">
                        <label for="checkbox_science">science</label>
                        <input class="hidden" id="checkbox_social_media" name="category" value="social media" type="radio">
                        <label for="checkbox_social_media">social media</label>
                        <input class="hidden" id="checkbox_videos" name="category" value="videos" type="radio">
                        <label for="checkbox_videos">videos</label>
                    </div>
                </div>
            </div>
            <span id="time_and_lang">
                <select class="custom-select  flat " name="language">
                    <c:forEach items="${Preferences.languages}" var="language">
                        <option value="${language.key}">${language.value}</option>
                    </c:forEach>
                </select>
                <select name="time_range" id="time-range" class="custom-select flat">
                    <option id="time-range-anytime" value="none" selected="selected">Anytime</option>
                    <option id="time-range-day" value="day">Last day</option>
                    <option id="time-range-week" value="week">Last week</option>
                    <option id="time-range-month" value="month">Last month</option>
                    <option id="time-range-year" value="year">Last year</option>
                </select>
            </span>
        </div>

    </form>
</div>
</body>
</html>