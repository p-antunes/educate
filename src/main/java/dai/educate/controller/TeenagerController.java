package dai.educate.controller;

import dai.educate.model.Create.CreatePsychologist;
import dai.educate.model.Create.CreateTeenager;
import dai.educate.model.Login;
import dai.educate.model.Psychologist;
import dai.educate.model.Role;
import dai.educate.model.Teenager;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.LoginRepository;
import dai.educate.repository.PsychologistRepository;
import dai.educate.repository.TeenagerRepository;
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
public class TeenagerController {

    @Autowired
    TeenagerRepository teenagerRepository;

    @Autowired
    LoginRepository loginRepository;

    //@PreAuthorize("hasRole('') or hasRole('') ")
    @GetMapping("/teenagers")
    public List<Teenager> listTeenager(@CurrentUser UserPrincipal currentUser) {
        return teenagerRepository.findAll();
    }

    @GetMapping("/teenagers/{idTeenager}")
    public Teenager findTeenager(/*@CurrentUser UserPrincipal currentUser*/ @PathVariable long idTeenager) {
        return teenagerRepository.findDistinctByIdTeenager(idTeenager);
    }
    @PostMapping("/teenagers") // Creat account
    public ResponseEntity<ApiResponse> savePsychologist(@RequestBody CreateTeenager teenager) {
        try {
            // Activity Attributes
            String email = teenager.getEmail();
            String password = teenager.getPassword();
            String confirmPassword = teenager.getConfirmPassword();
            String name =teenager.getName();
            Date birthDate = teenager.getBirthDate();
            String phoneNr = teenager.getPhoneNr();
            String city = teenager.getCity();
            String county = teenager.getCounty();
            String postalCode = teenager.getPostalCode();
            String address = teenager.getAddress();
            String school = teenager.getSchool();
            Role role = teenager.getRole();


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
            if(!(role.getIdRole() ==2)){
                return new ResponseEntity<ApiResponse>(
                        new ApiResponse(false, "Role inválido"),
                        HttpStatus.BAD_REQUEST);
            }

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);
            // Create Login
            Login log = new Login(null,email,hashedPassword,role);
            loginRepository.save(log);

            // Create Child
            Teenager newTeenager = new Teenager(null,name,birthDate,phoneNr,city,county, postalCode,address,school, log);
            teenagerRepository.save(newTeenager);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Conta criada com sucesso"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/teenagers/{idTeenager}")
    public ResponseEntity<ApiResponse> deleteTeenager(@PathVariable (value="idTeenager")long idTeenager) {
        try {
            Teenager teenager = teenagerRepository.findDistinctByIdTeenager(idTeenager);

            teenagerRepository.delete(teenager);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Right deleted.", idTeenager),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
