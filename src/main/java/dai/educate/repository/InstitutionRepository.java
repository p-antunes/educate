package dai.educate.repository;

import dai.educate.model.Child;
import dai.educate.model.Institution;
import dai.educate.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    Institution findDistinctByIdInstitution(Long idInstitution);

    Institution findDistinctByLogin(Login login);

    @Override
    List<Institution> findAll();

    List<Institution> findAllByAddress(String address);


    @Override
    void delete(Institution institution);

}
