package dai.educate.repository;

import dai.educate.model.Family;
import dai.educate.model.Login;
import dai.educate.model.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {

    Family findDistinctByIdFamily(Long idFamily);

    Family findDistinctByLogin(Login login);

    @Override
    List<Family> findAll();

    List<Family> findAllByAddress(String address);


    @Override
    void delete(Family family);

}