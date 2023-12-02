package com.simtechdata.jokes.joke;

import com.simtechdata.jokes.SendJoke;

class SubmitSingle {
    private final int formatVersion = 3;
    private final String category;
    private final String type;
    private final String joke;
    private final Flags flags;
    private final String lang;

    public SubmitSingle(SendJoke sendJoke) {
        this.category = sendJoke.getCategory();
        this.type = sendJoke.getType();
        this.joke = sendJoke.getJoke();
        this.lang = sendJoke.getLang();
        this.flags = new Flags(sendJoke.getFlags());
    }
}
