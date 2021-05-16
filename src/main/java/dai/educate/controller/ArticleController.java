package dai.educate.controller;

import dai.educate.model.Article;

import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.ArticleRepository;
import dai.educate.security.CurrentUser;
import dai.educate.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles")
    public List<Article> listArticle() {
        return articleRepository.findAll();
    }

    @GetMapping("/articles/{idArticle}")
    public Article findArticle( @PathVariable long idArticle) {
        return articleRepository.findByIdArticle(idArticle);
    }

    @PostMapping("/articles") // Creat account
    public ResponseEntity<ApiResponse> saveArticle(@CurrentUser UserPrincipal currentUser, @RequestBody Article artic) {
        try {

            String article = artic.getArticle();
            String link = artic.getLink();
            Long idUser = currentUser.getId();

            Article newArticle = new Article(null, article, link, idUser);
            articleRepository.save(newArticle);


            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Artigo criado com sucesso"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/articles/{idArticle}")
    public ResponseEntity<ApiResponse> deleteArticle(@PathVariable (value="idArticle")long idArticle) {
        try {
            Article article = articleRepository.findByIdArticle(idArticle);
            articleRepository.delete(article);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Article deleted."),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
