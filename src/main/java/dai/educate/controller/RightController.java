package dai.educate.controller;

import dai.educate.model.Rights;
import dai.educate.payload.resonse.ApiResponse;
import dai.educate.repository.RightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/rights")
    public ResponseEntity<ApiResponse> saveRight(@RequestBody Rights right) {
        try {
            // Activity Attributes
            long idRight = right.getId_right();
            String Right = right.getRights();

            // Create Right
            Rights newRight = new Rights(idRight, Right);
            rightRepository.save(newRight);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Right created"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/rights/{id_right}")
    public ResponseEntity<ApiResponse> deleteRight(@PathVariable (value="id_right")long id_right) {
        try {
            Rights right = rightRepository.findByIdRight(id_right);

            rightRepository.delete(right);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Right deleted.", id_right),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
