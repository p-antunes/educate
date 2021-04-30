package dai.educate.repository;

import dai.educate.model.VideoRight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VideoRightRepository extends JpaRepository<VideoRight, Long> {

    @Query("SELECT v FROM video_right v WHERE v.id_video = ?1")
    VideoRight findVideoRightById(Long id_video);

    List<VideoRight> findAll();

    @Override
    void delete(VideoRight video_right);

}
