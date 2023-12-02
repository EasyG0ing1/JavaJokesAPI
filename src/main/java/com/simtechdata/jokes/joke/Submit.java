package com.simtechdata.jokes.joke;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.simtechdata.jokes.SendJoke;
import com.simtechdata.jokes.enums.Type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Submit {
    private final String LF = System.getProperty("line.separator");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final SendJoke sendJoke;

    public Submit (SendJoke sendJoke) {
        this.sendJoke = sendJoke;
    }

    public String send() {
        String json;
        if(Type.TWOPART.code().equals(sendJoke.getType())) {
            SubmitTwoPart twoPart = new SubmitTwoPart(sendJoke);
            json = gson.toJson(twoPart);
        }
        else {
            SubmitSingle single = new SubmitSingle(sendJoke);
            json = gson.toJson(single);
        }
        return send(json, sendJoke.isDryRun());
    }

    private String send(String json, boolean dryRun) {
        String response;
        String baseURL = "https://v2.jokeapi.dev/submit";
        if (dryRun)
            baseURL += "?dry-run";
        int responseCode = 0;
        HttpURLConnection conn = null;
        String responseMessage = "";
        try {
            URL url = new URL(baseURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            responseMessage = conn.getResponseMessage();
            responseCode = conn.getResponseCode();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                response = responseCode + ";" + sb;
            }
        } catch (IOException e) {
            response = "The Joke Server threw an error code: " + responseCode + LF + "And a response message of: " + responseMessage + LF;
            if(responseCode == 500) {
                response += "A response code of 500 while the server is up and working, indicates that it is not currently accepting new jokes. You can create a GitHub issue at https://github.com/Sv443/JokeAPI to inquire about this if you're so inclined.";
            }
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return response;
    }
}
