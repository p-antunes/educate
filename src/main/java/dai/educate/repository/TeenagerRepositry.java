package dai.educate.repository;

import dai.educate.model.Teenager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeenagerRepositry extends JpaRepository<Teenager, Long> {

    @Query("SELECT v FROM teenager v WHERE v.idTeenager = ?1")
    Teenager findByIdTeenager(long idTeenager);

    List<Teenager> findAll();

}
