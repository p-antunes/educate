package dai.educate.repository;

import dai.educate.model.Child;
import dai.educate.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    Report findDistinctByIdReport(Long idReport);

    List<Report> findAll();

    @Query("SELECT v FROM report v WHERE v.idReport = ?1")
    Report findByIdReport(long idReport);



}
