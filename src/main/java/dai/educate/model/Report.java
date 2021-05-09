package dai.educate.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "report")
@Table(name="report")

public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReport;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date reportDate;

    @NotNull(message = "Can't be null")
    private String title;

    @NotNull(message = "Can't be null")
    private String description;

    @Email(message = "Insert a valid email")
    private String email;

    private String phoneNr;

    private String council;

    private String city;

    private String address;


    public Report(Long idReport, Date reportDate, @NotNull(message = "Can't be null") String title, @NotNull(message = "Can't be null") String description, @Email(message = "Insert a valid email") String email, String phoneNr, String council, String city, String address) {
        this.idReport = idReport;
        this.reportDate = reportDate;
        this.title = title;
        this.description = description;
        this.email = email;
        this.phoneNr = phoneNr;
        this.council = council;
        this.city = city;
        this.address = address;
    }

    public Report() {
    }

    public Long getIdReport() {
        return idReport;
    }

    public void setIdReport(Long idReport) {
        this.idReport = idReport;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getCouncil() {
        return council;
    }

    public void setCouncil(String council) {
        this.council = council;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
