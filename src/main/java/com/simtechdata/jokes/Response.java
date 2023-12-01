package com.simtechdata.jokes;

class Response {

    public static String getMessage(int code) {
        return switch(code) {
            case 400 -> "The request you have sent to JokeAPI is formatted incorrectly and cannot be processed";
            case 403 -> "You have been added to the blacklist due to malicious behavior and are not allowed to send requests to JokeAPI anymore";
            case 404 -> "The URL you have requested couldn't be found";
            case 413 -> "The payload data sent to the server exceeds the maximum size of 5120 bytes";
            case 414 -> "The URL exceeds the maximum length of 250 characters";
            case 429 -> "You have exceeded the limit of 120 requests per minute and have to wait a bit until you are allowed to send requests again";
            case 500 -> "There was a general internal error within JokeAPI. You can get more info from the properties in the response text";
            case 523 -> "Joke API server is temporarily offline due to maintenance or a dynamic IP update. Please try again later";
            default -> "";
        };
    }
}
