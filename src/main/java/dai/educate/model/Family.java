package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity(name = "family")
@Table(name = "family")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFamily;

    @NotBlank(message = "Can't be blank")
    private String name;

    private Date birthDate;
    private String city;
    private String county;
    private String postalCode;
    private String address;
    private String phoneNr;

    @ManyToOne
    @JoinColumn(name = "idLogin", referencedColumnName = "idLogin", nullable = false)
    private Login login;


    public Family(Long idFamily, @NotBlank(message = "Can't be blank") String name, Date birthDate, String city, String county, String postalCode, String address, String phoneNr, Login login) {
        this.idFamily = idFamily;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
        this.address = address;
        this.phoneNr = phoneNr;
        this.login = login;
    }

    public Family() {
    }

    public Long getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(Long idFamily) {
        this.idFamily = idFamily;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
