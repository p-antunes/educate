package dai.educate.repository;

import dai.educate.model.Article;
import dai.educate.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Query("SELECT v FROM complaint v WHERE v.idComplaint = ?1")
    Complaint findByIdComplaint(long idComplaint);

    @Override
    List<Complaint> findAll();

    @Override
    void delete(Complaint complaint);
}
