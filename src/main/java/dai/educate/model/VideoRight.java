package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "videoRight")
@Table(name = "videoRight")

public class VideoRight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Can't be blank")

    private Long idVideo;

    @NotBlank(message = "Can't be blank")

    private String linkVideo;

    public VideoRight(@NotBlank(message = "Can't be blank") Long idVideo, @NotBlank(message = "Can't be blank") String linkVideo) {
        this.idVideo = idVideo;
        this.linkVideo = linkVideo;
    }

    public VideoRight() {
    }

    public Long getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Long idVideo) {
        this.idVideo = idVideo;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }
}


