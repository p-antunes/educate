package dai.educate.controller;

import dai.educate.model.Create.CreateProChild;

import dai.educate.model.Institution;
import dai.educate.model.Login;
import dai.educate.model.ProChild;
import dai.educate.model.Role;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.LoginRepository;
import dai.educate.repository.ProchildRepository;
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
public class ProChildController {

    @Autowired
    ProchildRepository prochildRepository;

    @Autowired
    LoginRepository loginRepository;

    //@PreAuthorize("hasRole('') or hasRole('') ")
    @GetMapping("/prochilds")
    public List<ProChild> listProChild(@CurrentUser UserPrincipal currentUser) {
        return prochildRepository.findAll();
    }

    @GetMapping("/prochilds/{idProChild}")
    public ProChild findProChild(/*@CurrentUser UserPrincipal currentUser*/ @PathVariable long idProChild) {
       return prochildRepository.findDistinctByIdProChild(idProChild);
    }
    @PostMapping("/prochilds") // Creat account
    public ResponseEntity<ApiResponse> saveProChild(@RequestBody CreateProChild prochild) {
        try {

            String email = prochild.getEmail();
            String password = prochild.getPassword();
            String confirmPassword = prochild.getConfirmPassword();
            String name = prochild.getName();
            Date birthDate = prochild.getBirthDate();
            String phoneNr = prochild.getPhoneNr();
            String city = prochild.getCity();
            String county = prochild.getCounty();
            String postalCode = prochild.getPostalCode();
            String address = prochild.getAddress();
            Role role = prochild.getRole();


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
            if(!(role.getIdRole() ==5)){
                return new ResponseEntity<ApiResponse>(
                        new ApiResponse(false, "Role inválido"),
                        HttpStatus.BAD_REQUEST);
            }

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);
            // Create Login
            Login log = new Login(null,email,hashedPassword,role);
            loginRepository.save(log);


            ProChild newProChild = new ProChild(null,name,phoneNr,birthDate,city,county, postalCode,address, log);
            prochildRepository.save(newProChild);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Conta criada com sucesso"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/prochilds/{idProChild}")
    public ResponseEntity<ApiResponse> deleteProChild(@PathVariable (value="idProChild")long idProChild) {
        try {
            ProChild prochild = prochildRepository.findDistinctByIdProChild(idProChild);

            prochildRepository.delete(prochild);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "ProChild deleted.", idProChild),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
