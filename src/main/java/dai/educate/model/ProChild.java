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
    private int idProChild;

    @NotBlank(message = "Can't be blank")
    private String name;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "Can't be null")
    private Date birth_date;

    private String city;
    private String county;
    private String postal_code;
    private String address;

    @ManyToOne
    @JoinColumn(name = "idLogin", referencedColumnName = "idLogin", nullable = false)
    private Login login;


    public ProChild(int idProChild, @NotBlank(message = "Can't be blank") String name, @NotNull(message = "Can't be null") Date birth_date, String city, String county, String postal_code, String address, Login login) {
        this.idProChild = idProChild;
        this.name = name;
        this.birth_date = birth_date;
        this.city = city;
        this.county = county;
        this.postal_code = postal_code;
        this.address = address;
        this.login = login;
    }

    public ProChild() {
    }

    public int getIdProChild() {
        return idProChild;
    }

    public void setIdProChild(int idProChild) {
        this.idProChild = idProChild;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}

