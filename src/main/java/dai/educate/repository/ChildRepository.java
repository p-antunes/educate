package dai.educate.repository;

import dai.educate.model.Child;
import dai.educate.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    Child findDistinctByIdChild(Long idChild);


    Child findDistinctByLogin(Login login);

    @Query("SELECT v FROM child v WHERE v.idChild = ?1")
    Child findByIdChild(long idChild);

    @Override
    List<Child> findAll();

}
