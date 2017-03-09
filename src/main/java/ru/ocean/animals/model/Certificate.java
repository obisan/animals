package ru.ocean.animals.model;

import ru.ocean.animals.formatter.DateFormatter;
import ru.ocean.animals.formatter.DateFormatterImpl;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Certificate")
public class Certificate {
    private static DateFormatter formatter = DateFormatterImpl.getInstance();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "certificate_number")
    private String certificate_number;

    @Column(name = "certificate_date")
    private Timestamp certificate_date;

    @Column(name = "object_id")
    private Long object_id;

    @ManyToOne
    @JoinColumn(
            name = "object_id",
            foreignKey = @ForeignKey(name = "FK_Certificate_Object"),
            insertable = false,
            updatable = false
    )
    private Object object;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertificate_number() {
        return certificate_number;
    }

    public void setCertificate_number(String certificate_number) {
        this.certificate_number = certificate_number;
    }

    public String getCertificate_date() {
        return formatter.format2db(certificate_date);
    }

    public void setCertificate_date(String certificate_date) {
        this.certificate_date = formatter.parse(certificate_date);
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", certificate_number='" + certificate_number + '\'' +
                ", certificate_date=" + certificate_date +
                ", object_id=" + object_id +
                '}';
    }
}
