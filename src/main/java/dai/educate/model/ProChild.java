package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Entity(name = "prochild")
@Table(name="prochild")

public class ProChild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProChild;

    @NotBlank(message = "Can't be blank")
    private String name;
    private String phoneNr;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "Can't be null")
    private Date birthDate;

    private String city;
    private String county;
    private String postalCode;
    private String address;

    @ManyToOne
    @JoinColumn(name = "idLogin", referencedColumnName = "idLogin", nullable = false)
    private Login login;


    public ProChild(Long idProChild, @NotBlank(message = "Can't be blank") String name, String phoneNr, @NotNull(message = "Can't be null") Date birthDate, String city, String county, String postalCode, String address, Login login) {
        this.idProChild = idProChild;
        this.name = name;
        this.phoneNr = phoneNr;
        this.birthDate = birthDate;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
        this.address = address;
        this.login = login;
    }

    public ProChild() {
    }

    public Long getIdProChild() {
        return idProChild;
    }

    public void setIdProChild(Long idProChild) {
        this.idProChild = idProChild;
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}

