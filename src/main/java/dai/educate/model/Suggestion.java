package dai.educate.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="suggestion")
@Table(name="suggestion")

public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSuggestion;

    private String title;

    private String suggestion;

    private Long idUser;


    public Suggestion(Long idSuggestion, String title, String suggestion, Long idUser) {
        this.idSuggestion = idSuggestion;
        this.title = title;
        this.suggestion = suggestion;
        this.idUser = idUser;
    }

    public Suggestion() {
    }

    public Long getIdSuggestion() {
        return idSuggestion;
    }

    public void setIdSuggestion(Long idSuggestion) {
        this.idSuggestion = idSuggestion;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) { this.suggestion = suggestion; }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}


