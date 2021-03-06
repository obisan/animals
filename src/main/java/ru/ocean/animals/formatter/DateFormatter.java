package ru.ocean.animals.formatter;

import java.sql.Timestamp;

public interface DateFormatter {
    Timestamp parse(String datetime);

    String format(Timestamp timestamp);
    String format2db(Timestamp timestamp);

    String format2excel(Timestamp timestamp);
    String format2excelshort(String datetime);
}
