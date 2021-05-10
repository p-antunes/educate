package dai.educate.controller;


import dai.educate.model.Create.CreateFamily;
import dai.educate.model.Family;
import dai.educate.model.Login;
import dai.educate.model.Role;
import dai.educate.model.Update.updateEmail;
import dai.educate.model.Update.updatePassword;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.FamilyRepository;
import dai.educate.repository.LoginRepository;
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
            if(!(role.getIdRole() ==3)){
                return new ResponseEntity<ApiResponse>(
                        new ApiResponse(false, "Role inválido"),
                        HttpStatus.BAD_REQUEST);
            }

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);
            // Create Login
            Login log = new Login(null,email,hashedPassword,role);
            loginRepository.save(log);

            Family newFamily = new Family(null,name,birthDate,city,county, postalCode,address,phoneNr, log);
            familyRepository.save(newFamily);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Conta criada com sucesso"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/family/{idFamily}")
    public ResponseEntity<ApiResponse> deleteFamily(@PathVariable (value="idFamily")long idFamily) {
        try {
            Family family = familyRepository.findDistinctByIdFamily(idFamily);

            familyRepository.delete(family);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Family deleted.", idFamily),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/family/{idFamily}/password")
    public ResponseEntity<ApiResponse> updateFamilyPassword(@PathVariable (value="idFamily")long idFamily, @RequestBody updatePassword update) {
        try {
            if(familyRepository.findDistinctByIdFamily(idFamily).equals(null)){
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                        HttpStatus.BAD_REQUEST);
            }

            String newPassword = update.getPassword();
            String confirmPassword = update.getConfirmPassword();

            if (!confirmPassword.equals(newPassword)) {
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Passwords não são iguais."),
                        HttpStatus.BAD_REQUEST);
            }
            if (newPassword.length() < 6 || newPassword.length() > 24) {
                return new ResponseEntity<ApiResponse>(
                        new ApiResponse(false, "Password must contain between 6 to 24 characters"),
                        HttpStatus.BAD_REQUEST);
            }

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(newPassword);
            long idLogin = familyRepository.findDistinctByIdFamily(idFamily).getLogin().getIdLogin();

            loginRepository.updateLoginPassword(hashedPassword,idLogin);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Password updated.", idFamily),
                    HttpStatus.CREATED);
            //User userLogged = userRepository.findByUserId(currentUser.getId());
            //Set<Role> roleUserLogged = userLogged.getRoles();

            // Get Permissions
        /*if (String.valueOf(roleUserLogged).equals("[Role [id=0]]")
                || String.valueOf(roleUserLogged).equals("[Role [id=1]]")) {
            return alertLogRepository.findAlertLogsByPrison(userLogged.getPrison());
        }*/
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/family/{idFamily}")
    public ResponseEntity<ApiResponse> updateFamilyEmail(@PathVariable (value="idFamily")long idFamily, @RequestBody updateEmail update) {
        try {
            if(familyRepository.findDistinctByIdFamily(idFamily).equals(null)){
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                        HttpStatus.BAD_REQUEST);
            }

            String email = update.getEmail();


            if(email.trim().equals("")){
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Email inválido."),
                        HttpStatus.BAD_REQUEST);
            }

            long idLogin = familyRepository.findDistinctByIdFamily(idFamily).getLogin().getIdLogin();

            loginRepository.updateLoginEmail(email,idLogin);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Email updated.", idFamily),
                    HttpStatus.CREATED);
            //User userLogged = userRepository.findByUserId(currentUser.getId());
            //Set<Role> roleUserLogged = userLogged.getRoles();

            // Get Permissions
        /*if (String.valueOf(roleUserLogged).equals("[Role [id=0]]")
                || String.valueOf(roleUserLogged).equals("[Role [id=1]]")) {
            return alertLogRepository.findAlertLogsByPrison(userLogged.getPrison());
        }*/
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
