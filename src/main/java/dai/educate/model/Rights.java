package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "rights")
@Table(name = "rights")

public class Rights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRight;

    @NotBlank(message = "Can't be blank")
    private String rights;

    public Rights(Long idRight, @NotBlank(message = "Can't be blank") String rights) {
        this.idRight = idRight;
        this.rights = rights;
    }

    public Rights() {
    }

    public Long getIdRight() {
        return idRight;
    }

    public void setIdRight(Long idRight) {
        this.idRight = idRight;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }
}

