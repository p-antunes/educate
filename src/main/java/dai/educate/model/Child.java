/*package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "child")
@Table(name="child")

public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_child")
    private int id_child;

    @NotBlank(message = "Can't be blank")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Can't be blank")
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "birth_date")
    private Date birth_date;
    @Column(name = "city")
    private String city;
    @Column(name = "county")
    private String county;
    @Column(name = "postal_code")
    private String postal_code;
    @Column(name = "address")
    private String address;
    @Column(name = "school")
    private String school;


    @ManyToOne
    @JoinColumn(name = "id_login", referencedColumnName = "id_login", nullable = false)
    private login login;
*/