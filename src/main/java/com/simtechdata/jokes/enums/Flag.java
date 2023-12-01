package com.simtechdata.jokes.enums;

public enum Flag {
    NSFW,
    RELIGIOUS,
    POLITICAL,
    RACIST,
    SEXIST,
    EXPLICIT;

    public String code() {
        return switch(this) {
            case NSFW -> "nsfw";
            case RELIGIOUS -> "religious";
            case POLITICAL -> "political";
            case RACIST -> "racist";
            case SEXIST -> "sexist";
            case EXPLICIT -> "explicit";
        };
    }

}
