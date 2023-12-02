package com.simtechdata.jokes;

import com.simtechdata.jokes.enums.Category;
import com.simtechdata.jokes.enums.Flag;
import com.simtechdata.jokes.enums.Language;
import com.simtechdata.jokes.enums.Type;
import com.simtechdata.jokes.joke.Submit;

import java.util.ArrayList;
import java.util.Arrays;

import static com.simtechdata.jokes.enums.Category.*;
import static com.simtechdata.jokes.enums.Language.*;
import static com.simtechdata.jokes.enums.Type.*;


public class SendJoke {

    private final Category category;
    private final Type type;
    private final ArrayList<Flag> flags;
    private final Language lang;
    private final String joke;
    private final String setup;
    private final String delivery;
    private boolean dryRun;

    public static class Builder {
        private final Category category;
        private final Type type;
        private ArrayList<Flag> flags = new ArrayList<>();
        private Language lang = ENGLISH;
        private String joke = "";
        private String setup = "";
        private String delivery = "";

        public Builder(Category category, Type type, Flag... flags) {
            this.category = category.equals(ANY_CATEGORY) ? MISC : category;
            this.type = type;
            if(flags != null)
                this.flags = new ArrayList<>(Arrays.asList(flags));
        }

        public Builder setLanguage(Language language) {
            this.lang = language;
            return this;
        }

        public Builder twoPartSetup(String setup) {
            this.setup = setup;
            return this;
        }

        public Builder twoPartDelivery(String delivery) {
            this.delivery = delivery;
            return this;
        }

        public Builder twoPartSetupDelivery(String setup, String delivery) {
            this.setup = setup;
            this.delivery = delivery;
            return this;
        }

        public Builder joke(String joke) {
            this.joke = joke;
            return this;
        }

        public SendJoke build() {
            return new SendJoke(this);
        }
    }

    private SendJoke (Builder build) {
        this.category = build.category;
        this.type     = build.type;
        this.flags    = build.flags;
        this.lang     = build.lang;
        this.joke     = build.joke;
        this.setup    = build.setup;
        this.delivery = build.delivery;
    }

    private final String LF = System.getProperty("line.separator");
    public String send(boolean dryRun) {
        this.dryRun = dryRun;
        String message = "";
        if(this.type.equals(ANY)) {
            message = "- Joke type must be either Type.SINGLE or Type.TWOPART" + LF;
        }
        if(this.type.equals(TWOPART) && this.setup.isEmpty()) {
            message += "- The setup field for a Type.TWOPART joke cannot be blank" + LF;
        }
        if(this.type.equals(TWOPART) && this.delivery.isEmpty()) {
            message += "- The delivery field for a Type.TWOPART joke cannot be blank" + LF;
        }
        if(this.type.equals(SINGLE) && this.joke.isEmpty()) {
            message += "- The joke field for a Type.SINGLE joke cannot be blank" + LF;
        }
        if(!message.isEmpty()) {
            return message;
        }
        return new Submit(this).send();
    }

    public String getCategory() {
        return category.code();
    }

    public String getType() {
        return type.code();
    }

    public ArrayList<Flag> getFlags() {
        return flags;
    }

    public String getLang() {
        return lang.code();
    }

    public String getJoke() {
        return joke;
    }

    public String getSetup() {
        return setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public boolean isDryRun() {
        return dryRun;
    }
}
