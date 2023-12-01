package com.simtechdata.jokes.enums;

public enum Format {
    JSON,
    XML,
    YAML,
    TEXT;

    public String code() {
        return switch(this) {
            case JSON -> "json";
            case XML -> "xml";
            case YAML -> "yaml";
            case TEXT -> "txt";
        };
    }
}
