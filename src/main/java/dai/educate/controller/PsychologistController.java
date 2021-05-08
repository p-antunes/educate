package dai.educate.controller;

import dai.educate.model.Create.CreatePsychologist;
import dai.educate.model.Login;
import dai.educate.model.ProChild;
import dai.educate.model.Psychologist;
import dai.educate.model.Role;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.LoginRepository;
import dai.educate.repository.PsychologistRepository;
import dai.educate.security.CurrentUser;
import dai.educate.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PsychologistController {

    @Autowired
    PsychologistRepository psychologistRepository;

    @Autowired
    LoginRepository loginRepository;

    //@PreAuthorize("hasRole('') or hasRole('') ")
    @GetMapping("/psychologists")
    public List<Psychologist> listPsychologist(@CurrentUser UserPrincipal currentUser) {
        return psychologistRepository.findAll();
    }

    @GetMapping("/psychologists/{idPsychologist}")
    public Psychologist findPsychologist(/*@CurrentUser UserPrincipal currentUser*/ @PathVariable long idPsychologist) {
        return psychologistRepository.findDistinctByIdPsychologist(idPsychologist);
    }
    @PostMapping("/psychologists") // Creat account
    public ResponseEntity<ApiResponse> savePsychologist(@RequestBody CreatePsychologist psychologist) {
        try {

            String email = psychologist.getEmail();
            String password = psychologist.getPassword();
            String confirmPassword = psychologist.getConfirmPassword();
            String name = psychologist.getName();
            Date birthDate = psychologist.getBirthDate();
            String phoneNr = psychologist.getPhoneNr();
            String city = psychologist.getCity();
            String county = psychologist.getCounty();
            String postalCode = psychologist.getPostalCode();
            String address = psychologist.getAddress();
            Role role = psychologist.getRole();


            if (!confirmPassword.equals(password)) {
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Passwords não são iguais."),
                        HttpStatus.BAD_REQUEST);
            }
            if (loginRepository.existsByEmail(email)) {
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Email já em utilização."),
                        HttpStatus.BAD_REQUEST);
            }
            if (String.valueOf(password).length() < 6 || String.valueOf(password).length() > 24) {
                return new ResponseEntity<ApiResponse>(
                        new ApiResponse(false, "Password tem de conter entre 6 e 24 characters"),
                        HttpStatus.BAD_REQUEST);
            }
            if(!(role.getIdRole() ==6)){
                return new ResponseEntity<ApiResponse>(
                        new ApiResponse(false, "Role inválido"),
                        HttpStatus.BAD_REQUEST);
            }

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);
            // Create Login
            Login log = new Login(null,email,hashedPassword,role);
            loginRepository.save(log);

            // Create
            Psychologist newPsychologist = new Psychologist(null,name,birthDate,phoneNr,city,county, postalCode,address, log);
            psychologistRepository.save(newPsychologist);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Conta criada com sucesso"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/psychologists/{idPsychologist}")
    public ResponseEntity<ApiResponse> deletePsychologist(@PathVariable (value="idPsychologist")long idPsychologist) {
        try {
            Psychologist psychologist = psychologistRepository.findDistinctByIdPsychologist(idPsychologist);

            psychologistRepository.delete(psychologist);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Right deleted.", idPsychologist),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
