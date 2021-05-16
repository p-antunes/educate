package dai.educate.controller;


import dai.educate.model.Suggestion;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.ArticleRepository;
import dai.educate.repository.SuggestionRepository;
import dai.educate.security.CurrentUser;
import dai.educate.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SuggestionController {

    @Autowired
    SuggestionRepository suggestionRepository;

    @GetMapping("/suggestions")
    public List<Suggestion> listSuggestion() {
        return suggestionRepository.findAll();
    }

    @GetMapping("/suggestions/{idSuggestion}")
    public Suggestion findSuggestion( @PathVariable long idSuggestion) {
        return suggestionRepository.findByIdSuggestion(idSuggestion);
    }

    @PostMapping("/suggestions") // Creat account
    public ResponseEntity<ApiResponse> saveSuggestion(@CurrentUser UserPrincipal currentUser, @RequestBody Suggestion suggest) {
        try {

            String title = suggest.getTitle();
            String suggestion = suggest.getSuggestion();
            Long idUser = currentUser.getId();

            Suggestion newSuggestion = new Suggestion(null,title, suggestion, idUser);
            suggestionRepository.save(newSuggestion);


            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Sugestão criada com sucesso."),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/suggestions/{idSuggestion}")
    public ResponseEntity<ApiResponse> deleteSuggestion(@PathVariable (value="idSuggestion")long idSuggestion) {
        try {
            Suggestion suggestion = suggestionRepository.findByIdSuggestion(idSuggestion);
            suggestionRepository.delete(suggestion);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Sugestão eliminada com sucesso."),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
