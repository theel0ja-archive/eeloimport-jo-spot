<input type="checkbox" name="nav_toggle" id="nav_toggle" class="hidden">
<nav class="noselect" style="margin: 16px 0 16px 0">
    <span id="eelo_links">
        <a href="#">${t.t("smartphones")}</a>
        <a href="https://webmail.eelo.me">${t.t("mail")}</a>
        <a href="#">${t.t("drive")}</a>
    </span>
    <span>
        <a href="/preferences">${t.t("preferences")}</a>
    </span>
</nav>
<div id="nav_cover"></div>
<label for="nav_toggle" id="nav_toggle_btn">
    <svg class="menu-open" width="24px" height="24px">
        <path d="M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z"></path>
    </svg>
    <svg class="menu-close" width="24px" height="24px">
        <path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z"></path>
    </svg>
</label>