package com.simtechdata.jokes.joke;

import com.simtechdata.jokes.enums.Flag;

import java.util.ArrayList;

class Flags {
    private boolean nsfw;
    private boolean religious;
    private boolean political;
    private boolean racist;
    private boolean sexist;
    private boolean explicit;

    public Flags(ArrayList<Flag> flags) {
        nsfw      = false;
        religious = false;
        political = false;
        racist    = false;
        sexist    = false;
        explicit  = false;

        for(Flag flag : flags) {
            switch(flag) {
                case NSFW ->        nsfw        = true;
                case RELIGIOUS ->   religious   = true;
                case POLITICAL ->   political   = true;
                case RACIST ->      racist      = true;
                case SEXIST ->      sexist      = true;
                case EXPLICIT ->    explicit    = true;
            }
        }
    }

    public boolean hasFlags() {
        return nsfw     ||
               religious||
               political||
               racist   ||
               sexist   ||
               explicit;
    }

    public String getPretty() {
        StringBuilder sb = new StringBuilder();
        sb.append(nsfw ?        "\tnsfw\n" : "");
        sb.append(religious ?   "\treligious\n" : "");
        sb.append(political ?   "\tpolitical\n" : "");
        sb.append(racist ?      "\tracist\n" : "");
        sb.append(sexist ?      "\tsexist\n" : "");
        sb.append(explicit ?    "\texplicit\n" : "");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nsfw ?        "nsfw," : "");
        sb.append(religious ?   "religious," : "");
        sb.append(political ?   "political," : "");
        sb.append(racist ?      "racist," : "");
        sb.append(sexist ?      "sexist," : "");
        sb.append(explicit ?    "explicit," : "");
        return sb.substring(0, sb.length() - 1);
    }
}
