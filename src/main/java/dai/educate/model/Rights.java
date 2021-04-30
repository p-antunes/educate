package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "rights")
@Table(name = "rights")

public class Rights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_right;

    @NotBlank(message = "Can't be blank")
    private String rights;


    public Rights(Long id_right, @NotBlank(message = "Can't be blank") String name) {
        this.id_right = id_right;
        this.rights = name;
    }

    public Rights() {
    }

    public Long getId_right() {
        return id_right;
    }

    public void setId_right(Long id_right) {
        this.id_right = id_right;
    }


    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }
}
