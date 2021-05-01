package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity(name = "child")
@Table(name="child")

public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChild")
    private Long idChild;

    @NotBlank(message = "Can't be blank")
    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "address")
    private String address;

    @Column(name = "school")
    private String school;

    @ManyToOne
    @JoinColumn(name = "id_login", referencedColumnName = "id_login", nullable = false)
    private Login login;

    public Child(Long idChild, @NotBlank(message = "Can't be blank") String name, Date birthDate, String city, String county, String postalCode, String address, String school, Login login) {
        this.idChild = idChild;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
        this.county = county;
        this.postalCode = postalCode;
        this.address = address;
        this.school = school;
        this.login = login;
    }

    public Child() {
    }

    public Long getIdChild() {
        return idChild;
    }

    public void setIdChild(Long idChild) {
        this.idChild = idChild;
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