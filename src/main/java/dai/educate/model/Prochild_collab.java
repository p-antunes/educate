package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Entity(name = "prochild_collab")
@Table(name="prochild_collab")

public class Prochild_collab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCollab;

    @NotBlank(message = "Can't be blank")
    private String name;

    @NotBlank(message = "Can't be blank")
    private String user_name;
    private Date birth_date;
    private String city;
    private String county;
    private String postal_code;
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_login", referencedColumnName = "id_login", nullable = false)
    private Login login;


    public Prochild_collab(int idCollab, String name, String user_name, Date birth_date, String city, String county, String postal_code, String address, Login login) {
        this.idCollab = idCollab;
        this.name = name;
        this.user_name = user_name;
        this.birth_date = birth_date;
        this.city = city;
        this.county = county;
        this.postal_code = postal_code;
        this.address = address;
        this.login = login;
    }

    public Prochild_collab() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCollab() {
        return idCollab;
    }

    public void setIdCollab(int idCollab) {
        this.idCollab = idCollab;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(int Login) {
        this.login = login;
    }
}

