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
    private String user_name;
    private String birth_day;
    private String city;
    private String county;
    private String postal_code;
    private String address;
    private String phonenr;

    @ManyToOne
    @JoinColumn(name = "idLogin", referencedColumnName = "idLogin", nullable = false)
    private Login login;

    public Family(int idFamily, String name, String user_name, String birth_day, String city, String county, String postal_code, String address, String phone_nr, Login login) {
        this.idFamily = idFamily;
        this.name = name;
        this.user_name = user_name;
        this.birth_day = birth_day;
        this.city = city;
        this.county = county;
        this.postal_code = postal_code;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
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
