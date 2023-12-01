package com.simtechdata.jokes.classes;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TimeZone;

public class JokeError {
    private boolean error;
    private boolean internalError;
    private int code;
    private String message;
    private ArrayList<String> causedBy;
    private String additionalInfo;
    private long timestamp;
    private final String LF = System.getProperty("line.separator");

    public boolean isInternal() {
        return internalError;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<String> getCausedBy() {
        return causedBy;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        String header   = "**** ERROR ****";
        String internal = " Internal: " + (this.internalError ? "Yes" : "No");
        String code     = "     Code: " + this.code;
        String message  = "  Message: " + this.message;
        String caused   = "Caused By: " + this.causedBy;
        String add      = "More Info: " + this.additionalInfo;
        String time     = "Timestamp: " + getTime();
        return  header + LF +
                internal + LF +
                code  + LF +
                message + LF +
                caused + LF +
                add + LF +
                time;

    }

    private String getTime() {
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, TimeZone.getDefault().toZoneId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm:ss a");
        return dateTime.format(formatter);
    }

}
