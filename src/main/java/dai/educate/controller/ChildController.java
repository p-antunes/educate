package dai.educate.controller;


import dai.educate.model.Child;
import dai.educate.model.Create.CreateChild;
import dai.educate.model.Login;

import dai.educate.model.Role;
import dai.educate.model.custom.updateEmail;
import dai.educate.model.custom.updatePassword;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.ChildRepository;
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
public class ChildController {

    @Autowired
    ChildRepository childRepository;

    @Autowired
    LoginRepository loginRepository;

    //@PreAuthorize("hasRole('') or hasRole('') ")
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

    @DeleteMapping("/children/{idChild}")
    public ResponseEntity<ApiResponse> deleteChild(@PathVariable (value="idChild")long idChild) {
        try {
            Child child = childRepository.findDistinctByIdChild(idChild);

            childRepository.delete(child);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "child deleted.", idChild),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/children/{idChild}/password")
    public ResponseEntity<ApiResponse> updateChildPassword(@PathVariable (value="idChild")long idChild, @RequestBody updatePassword update) {
        try {
            if(childRepository.findDistinctByIdChild(idChild).equals(null)){
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                        HttpStatus.BAD_REQUEST);
            }

            String oldPassword = update.getOldPassword();
            String newPassword = update.getPassword();
            String confirmPassword = update.getConfirmPassword();


            if(oldPassword.equals(newPassword)){
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Passwords repetidas."),
                        HttpStatus.BAD_REQUEST);
            }

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
            long idLogin = childRepository.findDistinctByIdChild(idChild).getLogin().getIdLogin();

            loginRepository.updateLoginPassword(hashedPassword,idLogin);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Password updated.", idChild),
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

    @PutMapping("/children/{idChild}")
    public ResponseEntity<ApiResponse> updateChildEmail(@PathVariable (value="idChild")long idChild, @RequestBody updateEmail update) {
        try {
            if(childRepository.findDistinctByIdChild(idChild).equals(null)){
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                        HttpStatus.BAD_REQUEST);
            }

            String email = update.getEmail();


            if(email.trim().equals("")){
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Email inválido."),
                        HttpStatus.BAD_REQUEST);
            }

            long idLogin = childRepository.findDistinctByIdChild(idChild).getLogin().getIdLogin();

            loginRepository.updateLoginEmail(email,idLogin);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Email updated.", idChild),
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
