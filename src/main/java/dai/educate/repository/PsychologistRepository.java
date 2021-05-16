package dai.educate.repository;

import dai.educate.model.Login;
import dai.educate.model.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PsychologistRepository extends JpaRepository<Psychologist, Long> {

    Psychologist findDistinctByIdPsychologist(Long idPsychologist);

    Psychologist findDistinctByLogin(Login login);

    @Override
    List<Psychologist> findAll();

    List<Psychologist> findAllByAddress(String address);


    @Override
    void delete(Psychologist psychologist);

}