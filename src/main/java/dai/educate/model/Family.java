package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity(name = "family")
@Table(name = "family")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFamily;

    @NotBlank(message = "Can't be blank")
    private String name;

    @NotBlank(message = "Can't be blank")
    private String userName;
    private String birthDate;
    private String city;
    private String county;
    private String postalCode;
    private String address;
    private String phonenr;

    @ManyToOne
    @JoinColumn(name = "idLogin", referencedColumnName = "idLogin", nullable = false)
    private Login login;

    public Family(int idFamily, String name, String userName, String birthDate, String city, String county, String postalCode, String address, String phonenr, Login login) {
        this.idFamily = idFamily;
        this.name = name;
        this.userName = userName;
        this.birthDate = birthDate;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
        this.address = address;
        this.phonenr = phonenr;
        this.login = login;
    }

    public Family() {

    }

    public int getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(int idFamily) {
        this.idFamily = idFamily;
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
        this.userName = user_name;
    }

    public String getBirth_day() {
        return birthDate;
    }

    public void setBirth_day(String birth_day) {
        this.birthDate = birth_day;
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

    public void setCounty(String county) { this.county = county; }

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

    public String getPhonenr() {
        return phonenr;
    }

    public void setPhonenr(String phone_nr) {
        this.phonenr = phonenr;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
