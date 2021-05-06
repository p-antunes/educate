package dai.educate.repository;

import dai.educate.model.Login;
import dai.educate.model.ProChild;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProchildRepository extends JpaRepository<ProChild, Long> {

    ProChild findDistinctByIdProChild(Long idProChild);

    ProChild findDistinctByLogin(Login login);

    @Override
    List<ProChild> findAll();

    List<ProChild> findAllByAddress(String address);


    @Override
    void delete(ProChild proChildCollab);

}
