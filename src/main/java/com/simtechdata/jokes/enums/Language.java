package com.simtechdata.jokes.enums;

public enum Language {
    CZECH,
    GERMAN,
    ENGLISH,
    SPANISH,
    FRENCH,
    PORTUGUESE;

    public String code() {
        return switch(this) {
            case CZECH -> "cs";
            case GERMAN -> "de";
            case ENGLISH -> "en";
            case SPANISH -> "es";
            case FRENCH -> "fr";
            case PORTUGUESE -> "pt";
        };
    }


}
