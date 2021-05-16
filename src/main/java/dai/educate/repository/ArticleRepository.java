package dai.educate.repository;

import dai.educate.model.Article;
import dai.educate.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT v FROM article v WHERE v.idArticle = ?1")
    Article findByIdArticle(long idArticle);

    @Override
    List<Article> findAll();

    @Override
    void delete(Article Article);


}
