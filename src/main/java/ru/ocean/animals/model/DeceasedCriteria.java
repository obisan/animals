package ru.ocean.animals.model;

import ru.ocean.animals.formatter.DateFormatter;
import ru.ocean.animals.formatter.DateFormatterImpl;

import java.sql.Timestamp;

public class DeceasedCriteria {

    private DateFormatter dateFormatter = DateFormatterImpl.getInstance();

    private Timestamp   date_from;
    private Timestamp   date_to;
    private Long        specie_id;

    public String getDate_from() {
        return dateFormatter.format(date_from);
    }

    public String getDate_from_db() {
        return dateFormatter.format2db(date_from);
    }

    public void setDate_from(String date_from) {
        this.date_from = dateFormatter.parse(date_from);
    }

    public String getDate_to() {
        return dateFormatter.format(date_to);
    }

    public String getDate_to_db() {
        return dateFormatter.format2db(date_to);
    }

    public void setDate_to(String date_to) {
        this.date_to = dateFormatter.parse(date_to);
    }

    public Long getSpecie_id() {
        return specie_id;
    }

    public void setSpecie_id(Long specie_id) {
        this.specie_id = specie_id;
    }
}
