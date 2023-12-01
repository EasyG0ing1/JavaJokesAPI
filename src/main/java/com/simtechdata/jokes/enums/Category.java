package com.simtechdata.jokes.enums;

public enum Category {
    PROGRAMMING,
    MISC,
    DARK,
    PUN,
    SPOOKY,
    CHRISTMAS,
    ANY_CATEGORY;

    public String code() {
        return switch (this) {
            case PROGRAMMING -> "Programming";
            case MISC -> "Misc";
            case DARK -> "Dark";
            case PUN -> "Pun";
            case SPOOKY -> "Spooky";
            case CHRISTMAS -> "Christmas";
            case ANY_CATEGORY -> "Any";
        };
    }
}
