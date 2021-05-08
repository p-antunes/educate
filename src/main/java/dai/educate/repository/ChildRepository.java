package dai.educate.repository;

import dai.educate.model.Child;
import dai.educate.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    Child findDistinctByIdChild(Long idChild);

    Child findDistinctByLogin(Login login);

    @Override
    List<Child> findAll();

    List<Child> findAllByAddress(String address);


    @Override
    void delete(Child child);

}
