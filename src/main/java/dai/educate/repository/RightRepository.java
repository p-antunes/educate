package dai.educate.repository;

import dai.educate.model.Rights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RightRepository extends JpaRepository<Rights, Long> {

    @Query("SELECT v FROM rights v WHERE v.id_right = ?1")
    Rights findByIdRight(long id_right);

    List<Rights> findAll();


}
