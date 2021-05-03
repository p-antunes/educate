package dai.educate.repository;

import dai.educate.model.Child;
import dai.educate.model.Login;
import dai.educate.model.Prochild_collab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProchildRepository extends JpaRepository<Prochild_collab, Long> {

    Prochild_collab findDistinctByIdCollab(Long idCollab);

    Prochild_collab findDistinctByLogin(Login login);

    @Override
    List<Prochild_collab> findAll();

    List<Prochild_collab> findAllByAddress(String address);


    @Override
    void delete(Prochild_collab prochild_collab);

}
