package dai.educate.controller;


import dai.educate.model.Child;
import dai.educate.model.CreateChild;
import dai.educate.model.Login;
import dai.educate.model.Role;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.ChildRepository;
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
public class ChildController {

    @Autowired
    ChildRepository childRepository;

    @Autowired
    LoginRepository loginRepository;

    @PreAuthorize("hasRole('INSTITUTION') or hasRole('MANAGER') or hasRole('NETWORKMAN')")
    @GetMapping("/children")
    public List<Child> listChildren(@CurrentUser UserPrincipal currentUser) {
        return childRepository.findAll();
    }

    @GetMapping("/children/{idChild}")
    public Child findChild(/*@CurrentUser UserPrincipal currentUser*/ @PathVariable long idChild) {
        return childRepository.findDistinctByIdChild(idChild);
    }
    @PostMapping("/children") // Creat account
    public ResponseEntity<ApiResponse> saveChild(@RequestBody CreateChild child) {
        try {
            // Activity Attributes
            String email = child.getEmail();
            String password = child.getPassword();
            String confirmPassword = child.getConfirmPassword();
            String name = child.getName();
            Date birthDate = child.getBirthDate();
            String city = child.getCity();
            String county = child.getCounty();
            String postalCode = child.getPostalCode();
            String address = child.getAddress();
            String school = child.getSchool();
            Role role = child.getRole();


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
            Child newChild = new Child(null,name,birthDate,city,county, postalCode,address,school, log);
            childRepository.save(newChild);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Conta criada com sucesso", newChild.getIdChild()),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }


}
