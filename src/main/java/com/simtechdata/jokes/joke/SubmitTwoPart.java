package com.simtechdata.jokes.joke;

import com.simtechdata.jokes.SendJoke;

class SubmitTwoPart {
    private final int formatVersion = 3;
    private final String category;
    private final String type;
    private final String setup;
    private final String delivery;
    private final Flags flags;
    private final String lang;


    public SubmitTwoPart (SendJoke sendJoke) {
        this.category = sendJoke.getCategory();
        this.type = sendJoke.getType();
        this.setup = sendJoke.getSetup();
        this.delivery = sendJoke.getDelivery();
        this.lang = sendJoke.getLang();
        this.flags = new Flags(sendJoke.getFlags());
    }
}
