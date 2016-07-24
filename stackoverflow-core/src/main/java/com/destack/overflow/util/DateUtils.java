package com.destack.overflow.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Deepak
 *
 */
public class DateUtils {

    protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyddMM");

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

    static {
        DATE_FORMAT.setLenient(false);
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
    }

    /**
     * Verify Date with the required format
     * 
     * @param date
     *            Date in the format of <b>"yyyyddMM"</b>
     * @return
     */
    public static boolean dateVerifier(Long date) {
        try {
            if (date != null && date != 0) {
                DATE_FORMAT.parse(String.valueOf(date));
            } else if (date == null) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            LOGGER.error(e.toString());
            return false;
        }
        return true;
    }

    /**
     * Verify Dates with the required format
     * 
     * @param date1
     *            Date in the format of <b>"yyyyddMM"</b>
     * @param date2
     *            Date in the format of <b>"yyyyddMM"</b>
     * @return
     */
    public static boolean datesVerifier(Long date1, Long date2) {
        return dateVerifier(date1) && dateVerifier(date2);
    }

    /**
     * Validates date and converts to 10 digit Integer format
     * 
     * @param date
     *            Date in the format of <b>"yyyyddMM"</b>
     * @return valid date or "0"
     * @throws ParseException
     */
    public static Long dateToMilliSecondsConverter(Long date) throws ParseException {
        if (dateVerifier(date) && date != null) {
            return DATE_FORMAT.parse(String.valueOf(date)).getTime() / 1000;
        } else {
            return 0L;
        }
    }

    public static String milliSecondsDateToProperDate(Long date) {
        Calendar calendar;
        try {
            if (date != null) {
                calendar = Calendar.getInstance(TimeZone.getTimeZone("Etc/UTC"));
                calendar.setTimeInMillis(date * 1000);
                return String.valueOf(calendar.get(Calendar.DATE)).concat("-")
                        .concat(String.valueOf(calendar.get(Calendar.MONTH) + 1)).concat("-")
                        .concat(String.valueOf(calendar.get(Calendar.YEAR)));
            } else {
                throw new IllegalArgumentException("given date should be in Milli seconds format");
            }
        } catch (Exception e) {
            LOGGER.error("Error while parsing date {}", e);
        } finally {
            calendar = null;
        }
        return "";
    }
}
