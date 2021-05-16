package dai.educate.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="complaint")
@Table(name="complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComplaint;
    private Date date;
    private String title;
    private String complaint;
    private String name;
    private String phoneNr;
    private String county;
    private String city;
    private String address;
    private String postalCode;


    public Complaint(Long idComplaint, Date date, String title, String complaint, String name, String phoneNr, String county, String city, String address, String postalCode) {
        this.idComplaint = idComplaint;
        this.date = date;
        this.title = title;
        this.complaint = complaint;
        this.name = name;
        this.phoneNr = phoneNr;
        this.county = county;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
    }

    public Complaint() {
    }

    public Long getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(Long idComplaint) {
        this.idComplaint = idComplaint;
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

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
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

