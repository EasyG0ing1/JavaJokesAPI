package com.simtechdata.jokes.joke;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.simtechdata.jokes.enums.Category;
import com.simtechdata.jokes.enums.Flag;
import com.simtechdata.jokes.enums.Language;
import com.simtechdata.jokes.enums.Type;

import java.util.ArrayList;

public class SubmitTwoPart {
    private final int formatVersion = 3;
    private final String category;
    private final String type;
    private final String setup;
    private final String delivery;
    private final Flags flags;
    private final String lang;

    public SubmitTwoPart(Category category, Type type, String setup, String delivery, ArrayList<Flag> flags, Language lang) {
        this.category = category.code();
        this.type = type.code();
        this.setup = setup;
        this.delivery = delivery;
        this.lang = lang.code();
        this.flags = new Flags(flags);
    }

    public String submit(boolean dryRun) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this);
        return Submit.send(json, dryRun);
    }
}
