package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "institution")
@Table(name="institution")

public class Instituition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Can't be blank")
    @Column(name = "id_institution")
    private int idInstitution;

    @NotBlank(message = "Can't be blank")
    @Column(name = "name")
    private String name;

    @Column(name = "phone_nr")
    private String phoneNr;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_login", referencedColumnName = "id_login", nullable = false)
    private login login;

    public Instituition(@NotBlank(message = "Can't be blank") int idInstitution, @NotBlank(message = "Can't be blank") String name, String phoneNr, String city, String county, String postalCode, String address, login login) {
        this.idInstitution = idInstitution;
        this.name = name;
        this.phoneNr = phoneNr;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
        this.address = address;
        this.login = login;
    }

    public Instituition() {
    }

    public int getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
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

    public login getLogin() {
        return login;
    }

    public void setLogin(login login) {
        this.login = login;
    }
}
