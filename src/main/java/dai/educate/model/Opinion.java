package dai.educate.model;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="opinion")
@Table(name="opinion")

public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpinion;

    private String opinion;

    private Long idUser;


    public Opinion(Long idOpinion, String opinion, Long idUser) {
        this.idOpinion = idOpinion;
        this.opinion = opinion;
        this.idUser = idUser;
    }

    public Opinion() {
    }

    public Long getIdOpinion() {
        return idOpinion;
    }

    public void setIdOpinion(Long idOpinion) {
        this.idOpinion = idOpinion;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
