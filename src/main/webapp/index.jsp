<%@ page import="io.eelo.spot.data.Params" %>
<jsp:useBean id="t" scope="request" type="io.eelo.spot.web.Translator"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="description" content="eelo spot">
    <meta name="keywords" content="eelo, spot, search, search engine, metasearch, meta search">
    <meta name="generator" content="eelo/1">
    <meta name="referrer" content="no-referrer">
    <meta name="viewport" content="width=device-width, initial-scale=1 , maximum-scale=1.0, user-scalable=1">
    <title>eelo</title>
    <link rel="shortcut icon" href="/favicon.ico">
    <link rel="stylesheet" href="/css/eelo.min.css">
    <link rel="stylesheet" href="/css/utils.css">
</head>
<body>
<%@include file="topbar.jsp" %>
<div id="index">
    <img src="/img/eelo.png" alt="eelo logo" class="noselect"
         ondragstart="return false"/>
    <img id="logo_inline" src="/img/eelo_inline.png" alt="eelo logo"
         class="noselect" ondragstart="return false"/>
    <form id="search_form" role="search" action="/" method="post">
        <div id="search_input_container">
            <input type="search" name="q" class="form-control" id="q" placeholder="${t.t("Search for...")}"
                   autocomplete="off" autofocus="autofocus" onfocus="this.select()">
            <span class="tt-dropdown-menu" style="display: none"></span>
            <button type="submit">
                <svg width="24px" height="24px">
                    <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                </svg>
            </button>
        </div>
    </form>
</div>
</body>
</html>
<%if (!((Params) request.getAttribute("params")).getAutocompleter().equals("none")) {%>
<script src="a.js"></script>
<%}%>