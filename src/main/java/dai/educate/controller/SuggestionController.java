package dai.educate.controller;


import dai.educate.model.Complaint;
import dai.educate.model.Create.CreateSuggestion;
import dai.educate.model.Role;
import dai.educate.model.Suggestion;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.*;
import dai.educate.security.CurrentUser;
import dai.educate.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SuggestionController {

    @Autowired
    SuggestionRepository suggestionRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    ChildRepository childRepository;

    @Autowired
    TeenagerRepository teenagerRepository;

    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    InstitutionRepository institutionRepository;

    @GetMapping("/suggestions")
    public List<Suggestion> listSuggestion() {
        return suggestionRepository.findAll();
    }

    @GetMapping("/suggestions/{idSuggestion}")
    public Suggestion findSuggestion( @PathVariable long idSuggestion) {
        return suggestionRepository.findByIdSuggestion(idSuggestion);
    }

    @PostMapping("/suggestions")
    public ResponseEntity<ApiResponse> saveSuggestion(@CurrentUser UserPrincipal currentUser, @RequestBody CreateSuggestion suggest) {
        try {

            String title = suggest.getTitle();
            String suggestion = suggest.getSuggestion();
            String email = currentUser.getEmail();
            Role role = loginRepository.findDistinctByEmail(email).getRole();
            Long idUser = currentUser.getId();
            Date date = new Date(System.currentTimeMillis());

            if (role.getIdRole() == 1) {
                String name = childRepository.findDistinctByIdChild(idUser).getName();
                String county = childRepository.findDistinctByIdChild(idUser).getCounty();
                String city = childRepository.findDistinctByIdChild(idUser).getCity();
                String address = childRepository.findDistinctByIdChild(idUser).getAddress();
                String postCode = childRepository.findDistinctByIdChild(idUser).getPostalCode();

                Suggestion newSuggestion = new Suggestion(null, date, title, suggestion, name, null, county, city, address, postCode);
                suggestionRepository.save(newSuggestion);

                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Suggestion created successfully"), HttpStatus.CREATED);
            }
            if (role.getIdRole() == 2) {
                String name = teenagerRepository.findDistinctByIdTeenager(idUser).getName();
                String county = teenagerRepository.findDistinctByIdTeenager(idUser).getCounty();
                String city = teenagerRepository.findDistinctByIdTeenager(idUser).getCity();
                String address = teenagerRepository.findDistinctByIdTeenager(idUser).getAddress();
                String phoneNr = teenagerRepository.findDistinctByIdTeenager(idUser).getPhoneNr();
                String postCode = teenagerRepository.findDistinctByIdTeenager(idUser).getPostalCode();

                Suggestion newSuggestion = new Suggestion(null, date, title, suggestion, name, phoneNr, county, city, address, postCode);
                suggestionRepository.save(newSuggestion);

                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Suggestion created successfully"), HttpStatus.CREATED);
            }
            if (role.getIdRole() == 3) {
                String name = familyRepository.findDistinctByIdFamily(idUser).getName();
                String county = familyRepository.findDistinctByIdFamily(idUser).getCounty();
                String city = familyRepository.findDistinctByIdFamily(idUser).getCity();
                String address = familyRepository.findDistinctByIdFamily(idUser).getAddress();
                String phoneNr = familyRepository.findDistinctByIdFamily(idUser).getPhoneNr();
                String postCode = familyRepository.findDistinctByIdFamily(idUser).getPostalCode();

                Suggestion newSuggestion = new Suggestion(null, date, title, suggestion, name, phoneNr, county, city, address, postCode);
                suggestionRepository.save(newSuggestion);

                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Suggestion created successfully"),
                        HttpStatus.CREATED);

            }
            if (role.getIdRole() == 4) {
                String name = institutionRepository.findDistinctByIdInstitution(idUser).getName();
                String county = institutionRepository.findDistinctByIdInstitution(idUser).getCounty();
                String city = institutionRepository.findDistinctByIdInstitution(idUser).getCity();
                String address = institutionRepository.findDistinctByIdInstitution(idUser).getAddress();
                String postCode = institutionRepository.findDistinctByIdInstitution(idUser).getPostalCode();

                Suggestion newSuggestion = new Suggestion(null, date, title, suggestion, name, null, county, city, address, postCode);
                suggestionRepository.save(newSuggestion);


                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Sugestão criada com sucesso."),
                        HttpStatus.CREATED);
            }
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
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
