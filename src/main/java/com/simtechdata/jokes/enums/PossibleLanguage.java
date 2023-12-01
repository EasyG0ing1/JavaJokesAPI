package com.simtechdata.jokes.enums;

public enum PossibleLanguage {
    ABKHAZIAN,
    AFAR,
    AFRIKAANS,
    AKAN,
    ALBANIAN,
    AMHARIC,
    ARABIC,
    ARAGONESE,
    ARMENIAN,
    ASSAMESE,
    AVARIC,
    AVESTAN,
    AYMARA,
    AZERBAIJANI,
    BAMBARA,
    BASHKIR,
    BASQUE,
    BELARUSIAN,
    BENGALI,
    BIHARI_LANGUAGES,
    BISLAMA,
    BOKMAL_NORWEGIAN,
    BOSNIAN,
    BRETON,
    BULGARIAN,
    BURMESE,
    CATALAN,
    CENTRAL_KHMER,
    CHAMORRO,
    CHECHEN,
    CHICHEWA,
    CHINESE,
    CHURCH_SLAVIC,
    CHUVASH,
    CORNISH,
    CORSICAN,
    CREE,
    CROATIAN,
    CZECH,
    DANISH,
    DIVEHI,
    DUTCH,
    DZONGKHA,
    ENGLISH,
    ESPERANTO,
    ESTONIAN,
    EWE,
    FAROESE,
    FIJIAN,
    FINNISH,
    FRENCH,
    FULAH,
    GAELIC,
    GALICIAN,
    GANDA,
    GEORGIAN,
    GERMAN,
    GREEK_MODERN,
    GUARANI,
    GUJARATI,
    HAITIAN,
    HAUSA,
    HEBREW,
    HERERO,
    HINDI,
    HIRI_MOTU,
    HUNGARIAN,
    ICELANDIC,
    IDO,
    IGBO,
    INDONESIAN,
    INTERLINGUA,
    INTERLINGUE,
    INUKTITUT,
    INUPIAQ,
    IRISH,
    ITALIAN,
    JAPANESE,
    JAVANESE,
    KALAALLISUT,
    KANNADA,
    KANURI,
    KASHMIRI,
    KAZAKH,
    KIKUYU,
    KINYARWANDA,
    KIRGHIZ,
    KOMI,
    KONGO,
    KOREAN,
    KUANYAMA,
    KURDISH,
    LAO,
    LATIN,
    LATVIAN,
    LIMBURGAN,
    LINGALA,
    LITHUANIAN,
    LUBA_KATANGA,
    LUXEMBOURGISH,
    MACEDONIAN,
    MALAGASY,
    MALAY,
    MALAYALAM,
    MALTESE,
    MANX,
    MAORI,
    MARATHI,
    MARSHALLESE,
    MONGOLIAN,
    NAURU,
    NAVAJO,
    NDEBELE_NORTH,
    NDEBELE_SOUTH,
    NDONGA,
    NEPALI,
    NORTHERN_SAMI,
    NORWEGIAN,
    NORWEGIAN_NYNORSK,
    OCCITAN,
    OJIBWA,
    ORIYA,
    OROMO,
    OSSETIAN,
    PALI,
    PANJABI,
    PERSIAN,
    POLISH,
    PORTUGUESE,
    PUSHTO,
    QUECHUA,
    ROMANIAN,
    ROMANSH,
    RUNDI,
    RUSSIAN,
    SAMOAN,
    SANGO,
    SANSKRIT,
    SARDINIAN,
    SERBIAN,
    SHONA,
    SICHUAN_YI,
    SINDHI,
    SINHALA,
    SLOVAK,
    SLOVENIAN,
    SOMALI,
    SOTHO_SOUTHERN,
    SPANISH,
    SUNDANESE,
    SWAHILI,
    SWATI,
    SWEDISH,
    TAGALOG,
    TAHITIAN,
    TAJIK,
    TAMIL,
    TATAR,
    TELUGU,
    THAI,
    TIBETAN,
    TIGRINYA,
    TONGA,
    TSONGA,
    TSWANA,
    TURKISH,
    TURKMEN,
    TWI,
    UIGHUR,
    UKRAINIAN,
    URDU,
    UZBEK,
    VENDA,
    VIETNAMESE,
    VOLAPUK,
    WALLOON,
    WELSH,
    WESTERN_FRISIAN,
    WOLOF,
    XHOSA,
    YIDDISH,
    YORUBA,
    ZHUANG,
    ZULU;

    public String code() {
        return switch(this) {
            case ABKHAZIAN -> "ab";
            case AFAR -> "aa";
            case AFRIKAANS -> "af";
            case AKAN -> "ak";
            case ALBANIAN -> "sq";
            case AMHARIC -> "am";
            case ARABIC -> "ar";
            case ARAGONESE -> "an";
            case ARMENIAN -> "hy";
            case ASSAMESE -> "as";
            case AVARIC -> "av";
            case AVESTAN -> "ae";
            case AYMARA -> "ay";
            case AZERBAIJANI -> "az";
            case BAMBARA -> "bm";
            case BASHKIR -> "ba";
            case BASQUE -> "eu";
            case BELARUSIAN -> "be";
            case BENGALI -> "bn";
            case BIHARI_LANGUAGES -> "bh";
            case BISLAMA -> "bi";
            case BOKMAL_NORWEGIAN -> "nb";
            case BOSNIAN -> "bs";
            case BRETON -> "br";
            case BULGARIAN -> "bg";
            case BURMESE -> "my";
            case CATALAN -> "ca";
            case CENTRAL_KHMER -> "km";
            case CHAMORRO -> "ch";
            case CHECHEN -> "ce";
            case CHICHEWA -> "ny";
            case CHINESE -> "zh";
            case CHURCH_SLAVIC -> "cu";
            case CHUVASH -> "cv";
            case CORNISH -> "kw";
            case CORSICAN -> "co";
            case CREE -> "cr";
            case CROATIAN -> "hr";
            case CZECH -> "cs";
            case DANISH -> "da";
            case DIVEHI -> "dv";
            case DUTCH -> "nl";
            case DZONGKHA -> "dz";
            case ENGLISH -> "en";
            case ESPERANTO -> "eo";
            case ESTONIAN -> "et";
            case EWE -> "ee";
            case FAROESE -> "fo";
            case FIJIAN -> "fj";
            case FINNISH -> "fi";
            case FRENCH -> "fr";
            case FULAH -> "ff";
            case GAELIC -> "gd";
            case GALICIAN -> "gl";
            case GANDA -> "lg";
            case GEORGIAN -> "ka";
            case GERMAN -> "de";
            case GREEK_MODERN -> "el";
            case GUARANI -> "gn";
            case GUJARATI -> "gu";
            case HAITIAN -> "ht";
            case HAUSA -> "ha";
            case HEBREW -> "he";
            case HERERO -> "hz";
            case HINDI -> "hi";
            case HIRI_MOTU -> "ho";
            case HUNGARIAN -> "hu";
            case ICELANDIC -> "is";
            case IDO -> "io";
            case IGBO -> "ig";
            case INDONESIAN -> "id";
            case INTERLINGUA -> "ia";
            case INTERLINGUE -> "ie";
            case INUKTITUT -> "iu";
            case INUPIAQ -> "ik";
            case IRISH -> "ga";
            case ITALIAN -> "it";
            case JAPANESE -> "ja";
            case JAVANESE -> "jv";
            case KALAALLISUT -> "kl";
            case KANNADA -> "kn";
            case KANURI -> "kr";
            case KASHMIRI -> "ks";
            case KAZAKH -> "kk";
            case KIKUYU -> "ki";
            case KINYARWANDA -> "rw";
            case KIRGHIZ -> "ky";
            case KOMI -> "kv";
            case KONGO -> "kg";
            case KOREAN -> "ko";
            case KUANYAMA -> "kj";
            case KURDISH -> "ku";
            case LAO -> "lo";
            case LATIN -> "la";
            case LATVIAN -> "lv";
            case LIMBURGAN -> "li";
            case LINGALA -> "ln";
            case LITHUANIAN -> "lt";
            case LUBA_KATANGA -> "lu";
            case LUXEMBOURGISH -> "lb";
            case MACEDONIAN -> "mk";
            case MALAGASY -> "mg";
            case MALAY -> "ms";
            case MALAYALAM -> "ml";
            case MALTESE -> "mt";
            case MANX -> "gv";
            case MAORI -> "mi";
            case MARATHI -> "mr";
            case MARSHALLESE -> "mh";
            case MONGOLIAN -> "mn";
            case NAURU -> "na";
            case NAVAJO -> "nv";
            case NDEBELE_NORTH -> "nd";
            case NDEBELE_SOUTH -> "nr";
            case NDONGA -> "ng";
            case NEPALI -> "ne";
            case NORTHERN_SAMI -> "se";
            case NORWEGIAN -> "no";
            case NORWEGIAN_NYNORSK -> "nn";
            case OCCITAN -> "oc";
            case OJIBWA -> "oj";
            case ORIYA -> "or";
            case OROMO -> "om";
            case OSSETIAN -> "os";
            case PALI -> "pi";
            case PANJABI -> "pa";
            case PERSIAN -> "fa";
            case POLISH -> "pl";
            case PORTUGUESE -> "pt";
            case PUSHTO -> "ps";
            case QUECHUA -> "qu";
            case ROMANIAN -> "ro";
            case ROMANSH -> "rm";
            case RUNDI -> "rn";
            case RUSSIAN -> "ru";
            case SAMOAN -> "sm";
            case SANGO -> "sg";
            case SANSKRIT -> "sa";
            case SARDINIAN -> "sc";
            case SERBIAN -> "sr";
            case SHONA -> "sn";
            case SICHUAN_YI -> "ii";
            case SINDHI -> "sd";
            case SINHALA -> "si";
            case SLOVAK -> "sk";
            case SLOVENIAN -> "sl";
            case SOMALI -> "so";
            case SOTHO_SOUTHERN -> "st";
            case SPANISH -> "es";
            case SUNDANESE -> "su";
            case SWAHILI -> "sw";
            case SWATI -> "ss";
            case SWEDISH -> "sv";
            case TAGALOG -> "tl";
            case TAHITIAN -> "ty";
            case TAJIK -> "tg";
            case TAMIL -> "ta";
            case TATAR -> "tt";
            case TELUGU -> "te";
            case THAI -> "th";
            case TIBETAN -> "bo";
            case TIGRINYA -> "ti";
            case TONGA -> "to";
            case TSONGA -> "ts";
            case TSWANA -> "tn";
            case TURKISH -> "tr";
            case TURKMEN -> "tk";
            case TWI -> "tw";
            case UIGHUR -> "ug";
            case UKRAINIAN -> "uk";
            case URDU -> "ur";
            case UZBEK -> "uz";
            case VENDA -> "ve";
            case VIETNAMESE -> "vi";
            case VOLAPUK -> "vo";
            case WALLOON -> "wa";
            case WELSH -> "cy";
            case WESTERN_FRISIAN -> "fy";
            case WOLOF -> "wo";
            case XHOSA -> "xh";
            case YIDDISH -> "yi";
            case YORUBA -> "yo";
            case ZHUANG -> "za";
            case ZULU -> "zu";
        };
    }


}
