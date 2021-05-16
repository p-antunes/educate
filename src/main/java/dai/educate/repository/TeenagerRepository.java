package dai.educate.repository;

import dai.educate.model.Institution;
import dai.educate.model.Login;
import dai.educate.model.Teenager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeenagerRepository extends JpaRepository<Teenager, Long> {

    Teenager findDistinctByIdTeenager(Long idTeenager);

    Teenager findDistinctByLogin(Login login);

    @Query("SELECT v FROM teenager v WHERE v.idTeenager = ?1")
    Teenager findByIdTeenager(long idTeenager);

    List<Teenager> findAll();

    List<Institution> findAllByAddress(String address);


    @Override
    void delete(Teenager teenager);

}
