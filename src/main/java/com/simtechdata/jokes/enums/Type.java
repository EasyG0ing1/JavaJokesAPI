package com.simtechdata.jokes.enums;

public enum Type {
    SINGLE,
    TWOPART,
    ANY;

    public String code() {
        return switch(this) {
            case SINGLE -> "single";
            case TWOPART -> "twopart";
            case ANY -> "any";
        };
    }
}
