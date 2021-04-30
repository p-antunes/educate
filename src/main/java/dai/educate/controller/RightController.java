package dai.educate.controller;

import dai.educate.model.Rights;
import dai.educate.repository.RightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RightController {

    @Autowired
    RightRepository rightRepository;

    @GetMapping("/rights")
    public List<Rights> listRight(){
        return rightRepository.findAll();
    }

    @GetMapping("/rights/{id_right}")
    public Rights findRight(@PathVariable long id_right){
        return rightRepository.findByIdRight(id_right);
    }


}
