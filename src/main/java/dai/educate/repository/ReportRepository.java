package dai.educate.repository;

import dai.educate.model.Report;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository {

    @Query("SELECT v FROM report v WHERE v.idReport = ?1")
    Report findByIdReport(long idReport);

    List<Report> findAll();

}
