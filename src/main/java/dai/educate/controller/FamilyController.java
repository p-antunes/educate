package dai.educate.controller;


import dai.educate.model.Child;
import dai.educate.model.Create.CreateChild;
import dai.educate.model.Create.CreateFamily;
import dai.educate.model.Family;
import dai.educate.model.Login;
import dai.educate.model.Role;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.FamilyRepository;
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

@RestController
@RequestMapping(value = "/api")
public class FamilyController {

    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    LoginRepository loginRepository;

    //@PreAuthorize("hasRole('') or hasRole('') ")
    @GetMapping("/family")
    public List<Family> listChildren(@CurrentUser UserPrincipal currentUser) {
        return familyRepository.findAll();
    }

    @GetMapping("/family/{idFamily}")
    public Family findFamily(/*@CurrentUser UserPrincipal currentUser*/ @PathVariable long idFamily) {
        return familyRepository.findDistinctByIdFamily(idFamily);
    }
    @PostMapping("/family") // Creat account
    public ResponseEntity<ApiResponse> saveFamily(@RequestBody CreateFamily family) {
        try {
            // Activity Attributes
            String email = family.getEmail();
            String password = family.getPassword();
            String confirmPassword = family.getConfirmPassword();
            String name = family.getName();
            Date birthDate = family.getBirthDate();
            String phoneNr = family.getPhoneNr();
            String city = family.getCity();
            String county = family.getCounty();
            String postalCode = family.getPostalCode();
            String address = family.getAddress();
            Role role = family.getRole();


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
            if(!(role.getIdRole() ==1)){
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
            Family newFamily = new Family(null,name,birthDate,city,county, postalCode,address,phoneNr, log);
            familyRepository.save(newFamily);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Conta criada com sucesso"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}