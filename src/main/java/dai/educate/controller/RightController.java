package dai.educate.controller;

import dai.educate.model.Rights;
import dai.educate.payload.response.ApiResponse;
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

    @GetMapping("/rights/{idRight}")
    public Rights findRight(@PathVariable long idRight){
        return rightRepository.findByIdRight(idRight);
    }

    @PostMapping("/rights")
    public ResponseEntity<ApiResponse> saveRight(@RequestBody Rights right) {
        try {
            // Activity Attributes
            String Right = right.getRights();

            // Create Right
            Rights newRight = new Rights(null, Right);
            rightRepository.save(newRight);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Right created"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/rights/{id_right}")
    public ResponseEntity<ApiResponse> deleteRight(@PathVariable (value="idRight")long idRight) {
        try {
            Rights right = rightRepository.findByIdRight(idRight);

            rightRepository.delete(right);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Right deleted.", idRight),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
