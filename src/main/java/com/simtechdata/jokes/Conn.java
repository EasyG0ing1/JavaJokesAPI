package com.simtechdata.jokes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Conn {

    private URL url;
    private int responseCode;
    public String get(String url) {
        try {
            this.url = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) this.url.openConnection();
            conn.setRequestMethod("GET");
            responseCode = conn.getResponseCode();
            if(responseCode == 200 || responseCode == 500) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            }
            return "error";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getResponseCode() {
        return responseCode;
    }

}
