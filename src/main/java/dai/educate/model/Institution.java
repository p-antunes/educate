package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "institution")
@Table(name="institution")

public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Can't be blank")

    private Long idInstitution;

    @NotBlank(message = "Can't be blank")

    private String name;


    private String phoneNr;


    private String city;


    private String county;


    private String postalCode;


    private String address;

    @ManyToOne
    @JoinColumn(name = "idLogin", referencedColumnName = "idLogin", nullable = false)
    private Login login;

    public Institution(@NotBlank(message = "Can't be blank") Long idInstitution, @NotBlank(message = "Can't be blank") String name, String phoneNr, String city, String county, String postalCode, String address, Login login) {
        this.idInstitution = idInstitution;
        this.name = name;
        this.phoneNr = phoneNr;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
        this.address = address;
        this.login = login;
    }

    public Institution() {
    }

    public Long getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(Long idInstitution) {
        this.idInstitution = idInstitution;
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