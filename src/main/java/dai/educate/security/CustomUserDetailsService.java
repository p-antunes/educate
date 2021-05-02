package dai.educate.security;
/*
import dai.educate.model.Child;
import dai.educate.model.Institution;
import dai.educate.model.Login;
import dai.educate.model.Teenager;
import dai.educate.repository.ChildRepository;
import dai.educate.repository.LoginRepository;

import dai.educate.repository.TeenagerRepository;
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


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Let people login with or email
        try {
            Login user = loginRepository.findDistinctByEmail(email);

            if (user.getRole().getIdRole() == 0) {
                Child child = childRepository.findDistinctByLogin(user);
                return UserPrincipal.create(child.getIdChild(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole() == 1) {
                Teenager teenager = teenagerRepository.findDistinctByLogin(user);
                return UserPrincipal.create(teenager.getIdTeenager(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            } else {
                Child child = childRepository.findDistinctByLogin(user);
                return UserPrincipal.create(child.getIdChild(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
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
            if (user.getRole().getIdRole() == 0) {
                Child child = childRepository.findDistinctByLogin(user);
                return UserPrincipal.create(child.getIdChild(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole() == 1) {
                Teenager teenager = teenagerRepository.findDistinctByLogin(user);
                return UserPrincipal.create(teenager.getIdTeenager(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            } else {
                Child child = childRepository.findDistinctByLogin(user);
                return UserPrincipal.create(child.getIdChild(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found with id : " + idLogin);
        }
    }


    @Transactional
    public UserDetails loadUserByEmail(String email) {
        try {
            Login user = loginRepository.findDistinctByEmail(email);
            if (user.getRole().getIdRole() == 0) {
                Child child = childRepository.findDistinctByLogin(user);
                return UserPrincipal.create(child.getIdChild(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
            if (user.getRole().getIdRole() == 1) {
                Teenager teenager = teenagerRepository.findDistinctByLogin(user);
                return UserPrincipal.create(teenager.getIdTeenager(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            } else {
                Child child = childRepository.findDistinctByLogin(user);
                return UserPrincipal.create(child.getIdChild(), user.getEmail(), user.getPassword(), user.getRole().getName().name());
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found with email : " + email);
        }
    }
}
*/