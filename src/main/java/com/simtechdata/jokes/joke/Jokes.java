package com.simtechdata.jokes.joke;

import java.util.ArrayList;

class Jokes {
    private int totalCount;
    private ArrayList<String> categories;
    private ArrayList<String> flags;
    private ArrayList<String> types;
    private String submissionURL;
    private IdRange idRange;
    private ArrayList<SafeJoke> safeJokes;

    public int getTotalCount() {
        return totalCount;
    }
}
