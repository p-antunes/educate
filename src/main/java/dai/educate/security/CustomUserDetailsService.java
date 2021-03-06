package dai.educate.security;

import dai.educate.model.*;
import dai.educate.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

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


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Let people login with or email
        try {
            Login user = loginRepository.findDistinctByEmail(email);

            if (user.getRole().getIdRole() == 1) {
                Child child = childRepository.findDistinctByLogin(user);
                return UserPrincipal.create(child.getIdChild(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole() == 2) {
                Teenager teenager = teenagerRepository.findDistinctByLogin(user);
                return UserPrincipal.create(teenager.getIdTeenager(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole()==3) {
                Family family = familyRepository.findDistinctByLogin(user);
                return UserPrincipal.create(family.getIdFamily(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole()==4) {
                Institution institution = institutionRepository.findDistinctByLogin(user);
                return UserPrincipal.create(institution.getIdInstitution(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole()==5){
                ProChild prochild = prochildRepository.findDistinctByLogin(user);
                return  UserPrincipal.create(prochild.getIdProChild(),user.getEmail(), user.getPassword(), user.getRole().getName().name());
            } else {
                Psychologist psychologist = psychologistRepository.findDistinctByLogin(user);
                return UserPrincipal.create(psychologist.getIdPsychologist(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found with email : " + email);
        }

    }


    //  This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long idLogin) {
        try {
            Login user = loginRepository.findDistinctByIdLogin(idLogin);

            if(user.getRole().getIdRole() == 1) {
                Child child = childRepository.findDistinctByLogin(user);
                return UserPrincipal.create(child.getIdChild(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole() == 2) {
                Teenager teenager = teenagerRepository.findDistinctByLogin(user);
                return UserPrincipal.create(teenager.getIdTeenager(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole()==3) {
                Family family = familyRepository.findDistinctByLogin(user);
                return UserPrincipal.create(family.getIdFamily(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole()==4) {
                Institution institution = institutionRepository.findDistinctByLogin(user);
                return UserPrincipal.create(institution.getIdInstitution(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole()==5){
                ProChild prochild = prochildRepository.findDistinctByLogin(user);
                return  UserPrincipal.create(prochild.getIdProChild(),user.getEmail(), user.getPassword(), user.getRole().getName().name());
            } else {
                Psychologist psychologist = psychologistRepository.findDistinctByLogin(user);
                return UserPrincipal.create(psychologist.getIdPsychologist(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found with idLogin : " + idLogin);
        }
    }


    @Transactional
    public UserDetails loadUserByEmail(String email) {
        try {
            Login user = loginRepository.findDistinctByEmail(email);

            if (user.getRole().getIdRole() == 1) {
                Child child = childRepository.findDistinctByLogin(user);
                return UserPrincipal.create(child.getIdChild(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole() == 2) {
                Teenager teenager = teenagerRepository.findDistinctByLogin(user);
                return UserPrincipal.create(teenager.getIdTeenager(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole()==3) {
                Family family = familyRepository.findDistinctByLogin(user);
                return UserPrincipal.create(family.getIdFamily(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole()==4) {
                Institution institution = institutionRepository.findDistinctByLogin(user);
                return UserPrincipal.create(institution.getIdInstitution(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole()==5){
                ProChild prochild = prochildRepository.findDistinctByLogin(user);
                return  UserPrincipal.create(prochild.getIdProChild(),user.getEmail(), user.getPassword(), user.getRole().getName().name());
            } else {
                Psychologist psychologist = psychologistRepository.findDistinctByLogin(user);
                return UserPrincipal.create(psychologist.getIdPsychologist(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found with email : " + email);
        }
}}
