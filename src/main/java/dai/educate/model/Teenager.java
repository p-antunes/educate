package dai.educate.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "teenager")
@Table(name="teenager")
public class Teenager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTeenager")
    private Long idTeenager;

    @NotBlank(message = "Can't be blank")
    @Column(name = "name")
    private String name;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "phoneNr")
    private String phoneNr;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "address")
    private String address;

    @Column(name = "school")
    private String school;

    @ManyToOne
    @JoinColumn(name = "idLogin", referencedColumnName = "idLogin", nullable = false)
    private Login login;

    public Teenager(Long idTeenager, @NotBlank(message = "Can't be blank") String name, Date birthDate, String phoneNr, String city, String county, String postalCode, String address, String school, Login login) {
        this.idTeenager = idTeenager;
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNr = phoneNr;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
        this.address = address;
        this.school = school;
        this.login = login;
    }

    public Teenager() {
    }

    public Long getIdTeenager() {
        return idTeenager;
    }

    public void setIdTeenager(Long idTeenager) {
        this.idTeenager = idTeenager;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}