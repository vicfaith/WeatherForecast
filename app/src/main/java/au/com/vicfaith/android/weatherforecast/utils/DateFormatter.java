package au.com.vicfaith.android.weatherforecast.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatter {

    public static String format(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM HH:mm a");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time * 1000L);
        return sdf.format(calendar.getTime());
    }

    public static String getDate(long time) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(time * 1000);
        calendar.setTimeZone(TimeZone.getDefault());
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
    }
}
