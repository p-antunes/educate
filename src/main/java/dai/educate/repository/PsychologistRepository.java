package dai.educate.repository;

import dai.educate.model.Login;
import dai.educate.model.Prochild_collab;
import dai.educate.model.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PsychologistRepository extends JpaRepository<Psychologist, Long> {

    Psychologist findDistinctByIdPsychologist(Long idPsychologist);

    Psychologist findDistinctByLogin(Login login);

    @Override
    List<Psychologist> findAll();

    List<Psychologist> findAllByAddress(String address);


    @Override
    void delete(Psychologist psychologist);

}