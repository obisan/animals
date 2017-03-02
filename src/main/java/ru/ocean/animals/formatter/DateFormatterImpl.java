package ru.ocean.animals.formatter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatterImpl implements DateFormatter {

    public static class DateFormatterImplHolder {
        public static final DateFormatter HOLDER_INSTANCE = new DateFormatterImpl();
    }

    public static DateFormatter getInstance() {
        return DateFormatterImplHolder.HOLDER_INSTANCE;
    }

    private static SimpleDateFormat sdf_in_from_calendar    = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    private static SimpleDateFormat sdf_out_to_view         = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    private static SimpleDateFormat sdf_out_to_db           = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public Timestamp parse(String datetime) {
        Timestamp timestamp = null;
        try {
            timestamp = new Timestamp(sdf_in_from_calendar.parse(datetime).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    public String format(Timestamp timestamp) {
        if(timestamp != null)
            return sdf_out_to_view.format(timestamp);
        return null;
    }

    public String format2db(Timestamp timestamp) {
        if(timestamp != null)
            return sdf_out_to_db.format(timestamp);
        return null;
    }
}
