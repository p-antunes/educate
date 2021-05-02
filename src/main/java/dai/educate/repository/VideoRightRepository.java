package dai.educate.repository;

import dai.educate.model.VideoRight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VideoRightRepository extends JpaRepository<VideoRight, Long> {

    @Query("SELECT v FROM videoRight v WHERE v.idVideo = ?1")
    VideoRight findVideoRightById(Long idVideo);

    List<VideoRight> findAll();

    @Override
    void delete(VideoRight videoRight);

}
