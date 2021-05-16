package dai.educate.repository;

import dai.educate.model.Report;
import dai.educate.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    @Query("SELECT v FROM suggestion v WHERE v.idSuggestion = ?1")
    Suggestion findByIdSuggestion(long idSuggestion);

    @Override
    List<Suggestion> findAll();

    @Override
    void delete(Suggestion suggestion);


}