package com.simtechdata.jokes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.simtechdata.jokes.classes.JokeError;
import com.simtechdata.jokes.enums.*;
import com.simtechdata.jokes.joke.Info;
import com.simtechdata.jokes.joke.Joke;
import com.simtechdata.jokes.joke.Multi;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

import static com.simtechdata.jokes.enums.Language.*;
import static com.simtechdata.jokes.enums.Type.*;
import static com.simtechdata.jokes.enums.Format.*;

public class Jokes {


    private final Language LANGUAGE;
    private final Set<Flag> blackListSet;
    private final Set<Category> categorySet;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final String baseURL = "https://v2.jokeapi.dev/joke/%s?%s&%s&%s&%s&%s&%s%s";
    private final PossibleLanguage possibleLanguage;
    private int amount;
    private Conn conn = new Conn();
    private Format FORMAT;
    private Type TYPE;
    private String url;
    private String language;
    private final String contains;
    private String categories;
    private String blacklistFlags;
    private String type;
    private String amountString;
    private String format;
    private final String safeMode;
    private String idRange;
    private String serverResponse;
    private JokeError jokeError;

    public static class Builder {
        private Language language                 = ENGLISH;
        private final Set<Flag> blackListSet            = new HashSet<>();
        private final Set<Category> categorySet         = new HashSet<>();
        private Format format                     = JSON;
        private Type type                         = ANY;
        private String safeMode = "";
        private String contains = "";
        private String idRange = "";
        private PossibleLanguage possibleLanguage = null;

        public Builder addCategory(Category... categories) {
            Collection<Category> collection = Arrays.asList(categories);
            this.categorySet.addAll(collection);
            return this;
        }

        public Builder addBlackList(Flag... blackLists) {
            Collection<Flag> collection = Arrays.asList(blackLists);
            this.blackListSet.addAll(collection);
            return this;
        }

        public Builder setFormat(Format format) {
            this.format = format;
            return this;
        }

        public Builder setLanguage(Language language) {
            this.language = language;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder possibleLanguage(PossibleLanguage possibleLanguage) {
            this.possibleLanguage = possibleLanguage;
            return this;
        }

        public Builder safeMode() {
            this.safeMode = "safe-mode";
            return this;
        }

        public Builder idRange(int low, int high) {
            String lowBound = low < 0 ? "0" : String.valueOf(low);
            String highBound = high < 0 ? "100" : String.valueOf(high);
            if (low < high || low == high)
                this.idRange = "idRange=" + lowBound + "-" + highBound;
            else
                this.idRange = "idRange=" + highBound + "-" + lowBound;
            return this;
        }

        public Builder id(int id) {
            this.idRange = "idRange=" + (id < 0 ? "0" : String.valueOf(id));
            return this;
        }

        public Builder contains(String searchString) {
            UriComponents uriComponents = UriComponentsBuilder.newInstance().fragment(searchString).build();
            String encodedURI = uriComponents.encode().toUriString().replaceFirst("#","");
            this.contains = "contains=" + encodedURI;
            return this;
        }

        public Jokes build() {
            return new Jokes(this);
        }
    }

    private Jokes (Builder build) {
        this.LANGUAGE         = build.language;
        this.blackListSet     = build.blackListSet;
        this.categorySet      = build.categorySet;
        this.FORMAT           = build.format;
        this.TYPE             = build.type;
        this.possibleLanguage = build.possibleLanguage;
        this.safeMode         = build.safeMode;
        this.contains         = build.contains;
        setURL();
    }

    public int getTotalJokes() {
        String url = "https://jokeapi.dev/info";
        conn = new Conn();
        String json = conn.get(url);
        if(isValidJson(json)) {
            Info info = gson.fromJson(json, Info.class);
            return info.getTotalCount();
        }
        return 0;
    }

    private void setURL() {
        if(this.categorySet.isEmpty()) {
            this.categorySet.add(Category.ANY_CATEGORY);
        }
        if(this.TYPE.equals(ANY) || this.TYPE.equals(TWOPART)) {
            this.FORMAT = JSON;
        }
        this.format = "format=" + FORMAT.code();
        this.language = this.possibleLanguage != null ? "lang=" + possibleLanguage.code() : "lang=" + LANGUAGE.code();
        this.type = this.TYPE.equals(ANY) ? "" : "type=" + TYPE.code();
        String categoryString = "";
        String blacklistString = "";
        for(Category category : categorySet) {
            categoryString += category.code() + ",";
        }
        for(Flag item : blackListSet) {
            blacklistString += item.code() + ",";
        }
        this.blacklistFlags = this.blackListSet.isEmpty() ? "" : "blacklistFlags=" + blacklistString.substring(0, blacklistString.length() - 1);
        this.categories = categoryString.substring(0, categoryString.length() - 1);
        this.amountString = amount > 1 ? "amount=" + amount : "";
        url = String.format(baseURL,categories,format,blacklistFlags,type,language,amountString,safeMode,contains).replaceAll("&+","&");
    }

    public Multi getMulti(int qty1To10) {
        this.amount = qty1To10;
        String json = getJSON();
        if (isValidJson(json))
            return gson.fromJson(json, Multi.class);
        return null;
    }

    public String getJokeId(int id) {
        this.idRange = "idRange=" + id;
        return getAny();
    }

    public String getTwoPart() {
        TYPE = TWOPART;
        Joke joke = getJsonJoke();
        if(joke.isError()) {
            jokeError = gson.fromJson(serverResponse, JokeError.class);
            return "error";
        }
        return joke.getSetup() + ";" + joke.getDelivery();
    }

    public String getOnePart() {
        TYPE = ONEPART;
        Joke joke = getJsonJoke();
        if(joke.isError()) {
            jokeError = gson.fromJson(serverResponse, JokeError.class);
            return "error";
        }
        return joke.getJoke();
    }

    public String getAny() {
        String response;
        Joke joke = getJoke();
        if(joke.isError()) {
            if(joke.isServerError()) {
                return joke.getServerErrorMessage();
            }
            else {
                jokeError = gson.fromJson(serverResponse, JokeError.class);
                return "error";
            }
        }
        if (joke.getType().equals(TWOPART.code())) {
            response = joke.getSetup() + " " + joke.getDelivery();
        }
        else {
            response = joke.getJoke();
        }
        return response;
    }

    private Joke getJsonJoke() {
        FORMAT = JSON;
        setURL();
        conn = new Conn();
        serverResponse = conn.get(url);
        return gson.fromJson(serverResponse, Joke.class);
    }

    public String getJSON() {
        FORMAT = JSON;
        return getServerResponse();
    }

    public String getXML() {
        FORMAT = XML;
        return getServerResponse();
    }

    public String getYAML() {
        FORMAT = YAML;
        return getServerResponse();
    }

    public String getTEXT() {
        FORMAT = TEXT;
        return getServerResponse();
    }

    public Joke getJoke() {
        FORMAT = JSON;
        setURL();
        conn = new Conn();
        String json = getJSON();
        if(isValidJson(json)) {
            return gson.fromJson(json, Joke.class);
        }
        else {
            return new Joke(Response.getMessage(conn.getResponseCode()));
        }
    }

    private String getServerResponse() {
        setURL();
        conn = new Conn();
        serverResponse = conn.get(url);
        if (serverResponse.equals("error")) {
            return Response.getMessage(conn.getResponseCode());
        }
        return serverResponse;
    }

    public JokeError getError() {
        return jokeError;
    }

    public String getURL() {
        setURL();
        return url;
    }

    private boolean isValidJson(String jsonString) {
        try {
            JsonParser jsonParser = new JsonParser();
            jsonParser.parse(jsonString);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }


}
