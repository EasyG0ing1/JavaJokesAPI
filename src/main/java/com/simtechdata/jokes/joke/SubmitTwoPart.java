package com.simtechdata.jokes.joke;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.simtechdata.jokes.SendJoke;
import com.simtechdata.jokes.enums.Category;
import com.simtechdata.jokes.enums.Flag;
import com.simtechdata.jokes.enums.Language;
import com.simtechdata.jokes.enums.Type;

import java.util.ArrayList;

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
