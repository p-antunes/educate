package dai.educate.service;

import dai.educate.exception.ResourceNotFoundException;
import dai.educate.model.*;
import dai.educate.response.ApiResponse;
import dai.educate.response.JwtAuthenticationResponseRole;
import dai.educate.repository.*;
import dai.educate.security.CustomUserDetailsService;
import dai.educate.security.JwtTokenProvider;
import dai.educate.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.logging.Logger;

@Service
public class AuthService {

    protected final Logger log = Logger.getLogger(String.valueOf(this.getClass()));

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

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

    @Autowired
    ProchildRepository prochildRepository;

    @Autowired
    PsychologistRepository psychologistRepository;

    @Autowired
    JwtTokenProvider tokenProvider;


    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        try {
            Login user = loginRepository.findDistinctByEmail(loginRequest.getEmail());

            String roleString = "";
            roleString = user.getRole().getName().toString();

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateToken(authentication);
            CookieUtils.addCookie(response, "token", jwt, 604800000);

            System.out.println(user.getRole().getIdRole());

            if (user.getRole().getIdRole() == 1) {
                Child child = childRepository.findDistinctByLogin(user);
                return ResponseEntity.ok(new JwtAuthenticationResponseRole(jwt, roleString, child.getIdChild()));
            }
            if(user.getRole().getIdRole() == 2) {
                Teenager teen = teenagerRepository.findDistinctByLogin(user);
                return ResponseEntity.ok(new JwtAuthenticationResponseRole(jwt, roleString, teen.getIdTeenager()));
            }
            if (user.getRole().getIdRole() == 3) {
                Family family = familyRepository.findDistinctByLogin(user);
                return ResponseEntity.ok(new JwtAuthenticationResponseRole(jwt, roleString, family.getIdFamily()));
            }
            if (user.getRole().getIdRole() == 4) {
                Institution institution = institutionRepository.findDistinctByLogin(user);
                return ResponseEntity.ok(new JwtAuthenticationResponseRole(jwt, roleString, institution.getIdInstitution()));
            }
            if(user.getRole().getIdRole() == 5){
                ProChild prochild = prochildRepository.findDistinctByLogin(user);
                return ResponseEntity.ok(new JwtAuthenticationResponseRole(jwt, roleString, prochild.getIdProChild()));
            } else{
                Psychologist psychologist = psychologistRepository.findDistinctByLogin(user);
                return ResponseEntity.ok(new JwtAuthenticationResponseRole(jwt, roleString, psychologist.getIdPsychologist()));
            }
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Login not found"),
                    HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public ResponseEntity<ApiResponse> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(CookieUtils.getCookie(request,"token"));
        boolean isOK = CookieUtils.deleteCookie(request, response, "token");
        boolean isOK1 =CookieUtils.deleteCookie(request, response, "role");
        System.out.println(isOK);

        if (isOK == true) {
            return ResponseEntity.ok().body(new ApiResponse(true, "User logged out successfully"));
        }

        return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Must be logged in to logout"),
                HttpStatus.PRECONDITION_FAILED);
    }

}
