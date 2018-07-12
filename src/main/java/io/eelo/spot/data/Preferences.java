package io.eelo.spot.data;

import io.eelo.spot.answerers.Answerer;
import io.eelo.spot.answerers.Random;
import io.eelo.spot.answerers.Statistics;
import io.eelo.spot.autocompleter.Autocompleter;
import io.eelo.spot.engines.Engine;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Preferences {

    public static final Pair[] languages = new Pair[]{
            new Pair<>("ms-MY", "Bahasa Melayu (MY)"),
            new Pair<>("ca-ES", "Català (ES)"),
            new Pair<>("da-DK", "Dansk (DK)"),
            new Pair<>("de", "Deutsch (de)"),
            new Pair<>("de-AT", "Deutsch (AT)"),
            new Pair<>("de-CH", "Deutsch (CH)"),
            new Pair<>("de-DE", "Deutsch (DE)"),
            new Pair<>("et-EE", "Eesti (EE)"),
            new Pair<>("en", "English (en)"),
            new Pair<>("en-AU", "English (AU)"),
            new Pair<>("en-CA", "English (CA)"),
            new Pair<>("en-GB", "English (GB)"),
            new Pair<>("en-IN", "English (IN)"),
            new Pair<>("en-MY", "English (MY)"),
            new Pair<>("en-US", "English (US)"),
            new Pair<>("es", "Español (es)"),
            new Pair<>("es-AR", "Español (AR)"),
            new Pair<>("es-ES", "Español (ES)"),
            new Pair<>("es-MX", "Español (MX)"),
            new Pair<>("fr", "Français (fr)"),
            new Pair<>("fr-BE", "Français (BE)"),
            new Pair<>("fr-CA", "Français (CA)"),
            new Pair<>("fr-CH", "Français (CH)"),
            new Pair<>("fr-FR", "Français (FR)"),
            new Pair<>("hr-HR", "Hrvatski (HR)"),
            new Pair<>("id-ID", "Indonesia (ID)"),
            new Pair<>("it-IT", "Italiano (IT)"),
            new Pair<>("lv-LV", "Latviešu (LV)"),
            new Pair<>("lt-LT", "Lietuvių (LT)"),
            new Pair<>("hu-HU", "Magyar (HU)"),
            new Pair<>("nl", "Nederlands (nl)"),
            new Pair<>("nl-BE", "Nederlands (BE)"),
            new Pair<>("nl-NL", "Nederlands (NL)"),
            new Pair<>("nb-NO", "Norsk Bokmål (NO)"),
            new Pair<>("pl-PL", "Polski (PL)"),
            new Pair<>("pt", "Português (pt)"),
            new Pair<>("pt-BR", "Português (BR)"),
            new Pair<>("pt-PT", "Português (PT)"),
            new Pair<>("ro-RO", "Română (RO)"),
            new Pair<>("sk-SK", "Slovenčina (SK)"),
            new Pair<>("sl-SI", "Slovenščina (SI)"),
            new Pair<>("fi-FI", "Suomi (FI)"),
            new Pair<>("sv-SE", "Svenska (SE)"),
            new Pair<>("vi-VN", "Tiếng Việt (VN)"),
            new Pair<>("tr-TR", "Türkçe (TR)"),
            new Pair<>("is-IS", "Íslenska (IS)"),
            new Pair<>("cs-CZ", "Čeština (CZ)"),
            new Pair<>("el-GR", "Ελληνικά (GR)"),
            new Pair<>("bg-BG", "Български (BG)"),
            new Pair<>("ru-RU", "Русский (RU)"),
            new Pair<>("sr-RS", "Српски (RS)"),
            new Pair<>("uk-UA", "Українська (UA)"),
            new Pair<>("he-IL", "עברית (IL)"),
            new Pair<>("ar-SA", "العربية (SA)"),
            new Pair<>("fa-IR", "فارسی (IR)"),
            new Pair<>("th-TH", "ไทย (TH)"),
            new Pair<>("zh", "中文 (zh)"),
            new Pair<>("zh-CN", "中文 (CN)"),
            new Pair<>("zh-TW", "中文 (TW)"),
            new Pair<>("ja-JP", "日本語 (JP)"),
            new Pair<>("ko-KR", "한국어 (KR)")};

    public static final Pair[] locales = new Pair[]{
            new Pair<>("en", "English"),
            new Pair<>("ar", "العَرَبِيَّة (Arabic)"),
            new Pair<>("bg", "Български (Bulgarian)"),
            new Pair<>("cs", "Čeština (Czech)"),
            new Pair<>("da", "Dansk (Danish)"),
            new Pair<>("de", "Deutsch (German)"),
            new Pair<>("el_GR", "Ελληνικά (Greek_Greece)"),
            new Pair<>("eo", "Esperanto (Esperanto)"),
            new Pair<>("es", "Español (Spanish)"),
            new Pair<>("fi", "Suomi (Finnish)"),
            new Pair<>("fil", "Wikang Filipino (Filipino)"),
            new Pair<>("fr", "Français (French)"),
            new Pair<>("he", "עברית (Hebrew)"),
            new Pair<>("hr", "Hrvatski (Croatian)"),
            new Pair<>("hu", "Magyar (Hungarian)"),
            new Pair<>("it", "Italiano (Italian)"),
            new Pair<>("ja", "日本語 (Japanese)"),
            new Pair<>("nl", "Nederlands (Dutch)"),
            new Pair<>("pl", "Polszczyzna (Polish)"),
            new Pair<>("pt", "Português (Portuguese)"),
            new Pair<>("pt_BR", "Português (Portuguese_Brazil)"),
            new Pair<>("ro", "Română (Romanian)"),
            new Pair<>("ru", "Русский (Russian)"),
            new Pair<>("sk", "Slovenčina (Slovak)"),
            new Pair<>("sl", "Slovenski (Slovene)"),
            new Pair<>("sr", "српски (Serbian)"),
            new Pair<>("sv", "Svenska (Swedish)"),
            new Pair<>("tr", "Türkçe (Turkish)"),
            new Pair<>("zh", "中文 (Chinese)"),
            new Pair<>("zh_TW", "國語 (Taiwanese Mandarin),")};

    public static final String[] categories = {"general", "images", "videos", "map", "it", "science", "files", "music", "social media", "news"};

    public static final Map<String, Engine[]> enginesByCategory = new HashMap<>();
    public static final Map<String, Engine> enginesById = new HashMap<>();

    public static final Answerer[] answerers = {new Random(), new Statistics()};

    public static Map<String, Autocompleter> autocompletersById = new HashMap<>();
}
