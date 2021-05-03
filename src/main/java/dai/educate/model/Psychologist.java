package dai.educate.model;

import javax.persistence.*;

@Entity(name = "psychologist")
@Table(name = "psychologist")

public class Psychologist {

    @Id
    private int idPsychologist;
    private String name;
    private String userName;
    private String birthDate;
    private String city;
    private String county;
    private String postalCode;
    private String address;

    @ManyToOne
    @JoinColumn(name = "idLogin", referencedColumnName = "idLogin", nullable = false)
    private Login login;

    public Psychologist(int idPsychologist, String name, String userName, String birthDate, String city, String county, String postalCode, String address, int idLogin) {
        this.idPsychologist = idPsychologist;
        this.name = name;
        this.userName = userName;
        this.birthDate = birthDate;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
        this.address = address;
        this.login = login;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user_name) {
        this.userName = userName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public void setLogin(Login login) {
        this.login = login;
    }
}
