package com.simtechdata.jokes.joke;

import com.simtechdata.jokes.enums.Type;

public class Joke {

    public Joke() {}

    public Joke(String error) {
        this.serverError = true;
        this.error = true;
        this.serverErrorMessage = error;
    }
    private boolean error;
    private boolean serverError;
    private String serverErrorMessage;
    private String category;
    private String type;
    private String joke;
    private Flags flags;
    private int id;
    private boolean safe;
    private String lang;
    private String setup;
    private String delivery;

    public boolean isSingle() {
        return type.equals(Type.ONEPART.code());
    }

    public boolean isTwoPart() {
        return type.equals(Type.TWOPART.code());
    }
    public boolean isServerError() {
        return serverError;
    }

    public String getServerErrorMessage() {
        return serverErrorMessage;
    }

    public boolean isError() {
        return error;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getJoke() {
        return joke;
    }

    public String getFlags() {
        return flags.toString();
    }

    public int getId() {
        return id;
    }

    public boolean isSafe() {
        return safe;
    }

    public String getLang() {
        return lang;
    }

    public String getSetup() {
        return setup;
    }

    public String getDelivery() {
        return delivery;
    }
}
