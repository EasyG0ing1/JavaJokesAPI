package com.simtechdata.jokes.enums;

public enum Type {
    ONEPART,
    TWOPART,
    ANY;

    public String code() {
        return switch(this) {
            case ONEPART -> "single";
            case TWOPART -> "twopart";
            case ANY -> "any";
        };
    }
}
