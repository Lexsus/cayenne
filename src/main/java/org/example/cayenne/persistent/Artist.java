package org.example.cayenne.persistent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.example.cayenne.persistent.auto._Artist;

public class Artist extends _Artist {

    static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";
    private static final long serialVersionUID = 1L;
    /**
     * Sets date of birth using a string in format yyyyMMdd.
     */
    public void setDateOfBirthString(String yearMonthDay) {
        if (yearMonthDay == null) {
            setDateOfBirth(null);
        } else {

            LocalDate date;
            try {
                DateTimeFormatter formatter = DateTimeFormatter
                        .ofPattern(DEFAULT_DATE_FORMAT);
                date = LocalDate.parse(yearMonthDay, formatter);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException(
                        "A date argument must be in format '"
                                + DEFAULT_DATE_FORMAT + "': " + yearMonthDay);
            }
            setDateOfBirth(date);
        }
    }

}
