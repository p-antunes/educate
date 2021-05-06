package dai.educate.controller;

import dai.educate.model.Create.CreateInstitution;
import dai.educate.model.Family;
import dai.educate.model.Institution;
import dai.educate.model.Login;
import dai.educate.model.Role;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.InstitutionRepository;
import dai.educate.repository.LoginRepository;
import dai.educate.security.CurrentUser;
import dai.educate.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

public class InstitutionController {
    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    LoginRepository loginRepository;

    //@PreAuthorize("hasRole('') or hasRole('')")
    @GetMapping("/children")
    public List<Institution> listInstitution(@CurrentUser UserPrincipal currentUser) {
        return institutionRepository.findAll();
    }

    @GetMapping("/institution/{idInstitution}")
    public Institution findInstitution(/*@CurrentUser UserPrincipal currentUser*/ @PathVariable long idInstitution) {
        return institutionRepository.findDistinctByIdInstitution(idInstitution);
    }
    @PostMapping("/institution") // Creat account
    public ResponseEntity<ApiResponse> saveInstitution(@RequestBody CreateInstitution institution) {
        try {
            // Activity Attributes
            String email = institution.getEmail();
            String password = institution.getPassword();
            String confirmPassword = institution.getConfirmPassword();
            String name = institution.getName();
            String city = institution.getCity();
            String phoneNr = institution.getPhoneNr();
            String county = institution.getCounty();
            String postalCode = institution.getPostalCode();
            String address = institution.getAddress();
            Role role = institution.getRole();


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
            if(!(role.getIdRole() ==4)){
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
            Institution newInstitution = new Institution(null,name,phoneNr,city,county, postalCode,address, log);
            institutionRepository.save(newInstitution);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Conta criada com sucesso"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/institutions/{idInstitution}")
    public ResponseEntity<ApiResponse> deleteInstitution(@PathVariable (value="idInstitution")long idInstitution) {
        try {
            Institution institution = institutionRepository.findDistinctByIdInstitution(idInstitution);

            institutionRepository.delete(institution);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Right deleted.", idInstitution),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}

