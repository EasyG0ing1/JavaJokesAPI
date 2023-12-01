module com.simtechdata.jokeapi {
    requires com.google.gson;
    requires spring.web;

    exports com.simtechdata.jokes;
    exports com.simtechdata.jokes.enums;

    opens com.simtechdata.jokes.joke to com.google.gson;
}
