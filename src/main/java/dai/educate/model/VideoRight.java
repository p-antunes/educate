package dai.educate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "video_right")
@Table(name = "video_right")

public class VideoRight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Can't be blank")
    private Long id_video;

    @NotBlank(message = "Can't be blank")
    private String link_video;

    public VideoRight(String link_video) {
        this.id_video = id_video;
        this.link_video = link_video;
    }

    public VideoRight() {

    }

    public Long getId_video() {
        return id_video;
    }

    public void setId_video(Long id_video) {
        this.id_video = id_video;
    }

    public String getLink_video() {
        return link_video;
    }

    public void setLink_video(String link_video) {
        this.link_video = link_video;
    }
}
