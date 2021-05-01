package dai.educate.repository;

import dai.educate.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {

    @Query("SELECT v FROM child v WHERE v.idChild = ?1")
    Child findByIdChild(long idChild);

    List<Child> findAll();

}
