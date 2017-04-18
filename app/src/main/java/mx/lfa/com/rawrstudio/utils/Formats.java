package mx.lfa.com.rawrstudio.utils;

import java.text.SimpleDateFormat;

/**
 * Created by Ricardo Rodriguez on 4/18/2017.
 */

public class Formats {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * Gets date format.
     *
     * @return the date format
     */
    public static SimpleDateFormat getDateFormat() {
        return DATE_FORMAT;
    }
}
