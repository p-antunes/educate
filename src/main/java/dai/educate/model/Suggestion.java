package dai.educate.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="suggestion")
@Table(name="suggestion")

public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSuggestion;
    private Date date;
    private String title;
    private String suggestion;
    private String name;
    private String phoneNr;
    private String county;
    private String city;
    private String address;
    private String postalCode;


    public Suggestion(Long idSuggestion, Date date, String title, String suggestion, String name, String phoneNr, String county, String city, String address, String postalCode) {
        this.idSuggestion = idSuggestion;
        this.date = date;
        this.title = title;
        this.suggestion = suggestion;
        this.name = name;
        this.phoneNr = phoneNr;
        this.county = county;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
    }

    public Suggestion() {
    }

    public Long getIdSuggestion() {
        return idSuggestion;
    }

    public void setIdSuggestion(Long idSuggestion) {
        this.idSuggestion = idSuggestion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}


