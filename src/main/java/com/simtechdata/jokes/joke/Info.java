package com.simtechdata.jokes.joke;

import java.util.ArrayList;

public class Info {
    private boolean error;
    private String version;
    private Jokes jokes;
    private ArrayList<String> formats;
    private int jokeLanguages;
    private int systemLanguages;
    private String info;
    private long timestamp;

    public int getTotalCount() {
        return jokes.getTotalCount();
    }
}
