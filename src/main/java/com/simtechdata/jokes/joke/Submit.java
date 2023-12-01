package com.simtechdata.jokes.joke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Submit {
    private static final String LF = System.getProperty("line.separator");

    public static String send(String json, boolean dryRun) {
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
                System.out.println("Response Message: " + sb);
                response = responseCode + ";" + sb;
            }
        } catch (IOException e) {
            response = "The Joke Server threw an error code: " + responseCode + LF + "And a response message of: " + responseMessage;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return response;
    }
}
