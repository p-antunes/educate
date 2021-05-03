package dai.educate.model;

import javax.persistence.*;

@Entity(name = "psychologist")
@Table(name = "psychologist")

public class Psychologist {

    @Id
    private int idPsychologist;
    private String name;
    private String user_name;
    private String birth_date;
    private String city;
    private String county;
    private String postal_code;
    private String address;
    private int id_login;

    public Psychologist(int idPsychologist, String name, String user_name, String birth_date, String city, String county, String postal_code, String address, int id_login) {
        this.idPsychologist = idPsychologist;
        this.name = name;
        this.user_name = user_name;
        this.birth_date = birth_date;
        this.city = city;
        this.county = county;
        this.postal_code = postal_code;
        this.address = address;
        this.id_login = id_login;
    }

    public Psychologist() {

    }

    public int getIdPsychologist() {
        return idPsychologist;
    }

    public void setIdPsychologist(int idPsychologist) {
        this.idPsychologist = idPsychologist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
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

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }
}
