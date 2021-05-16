package dai.educate.model;

import javax.persistence.*;

@Entity(name="complaint")
@Table(name="complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComplaint;
    private String title;
    private String complaint;
    private Long idUser;

    public Complaint(Long idComplaint, String title, String complaint, Long idUser) {
        this.idComplaint = idComplaint;
        this.title = title;
        this.complaint = complaint;
        this.idUser = idUser;
    }

    public Complaint() {
    }

    public Long getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(Long idComplaint) {
        this.idComplaint = idComplaint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}

