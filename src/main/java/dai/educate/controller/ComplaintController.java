package dai.educate.controller;

import dai.educate.model.Complaint;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.ComplaintRepository;
import dai.educate.security.CurrentUser;
import dai.educate.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ComplaintController {

    @Autowired
    ComplaintRepository complaintRepository;

    @GetMapping("/complaints")
    public List<Complaint> listComplaint() {
        return complaintRepository.findAll();
    }

    @GetMapping("/complaints/{idComplaint}")
    public Complaint findComplaint( @PathVariable long idComplaint) {
        return complaintRepository.findByIdComplaint(idComplaint);
    }

    @PostMapping("/complaints")
    public ResponseEntity<ApiResponse> saveComplaint(@CurrentUser UserPrincipal currentUser, @RequestBody Complaint comp) {
        try {

            String complaint = comp.getComplaint();
            String title = comp.getTitle();
            Long idUser = currentUser.getId();

            Complaint newComplaint = new Complaint(null,title, complaint, idUser);
            complaintRepository.save(newComplaint);


            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Complaint created successfully"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/complaints/{idComplaint}")
    public ResponseEntity<ApiResponse> deleteArticle(@PathVariable (value="idComplaint")long idComplaint) {
        try {
            Complaint complaint = complaintRepository.findByIdComplaint(idComplaint);
            complaintRepository.delete(complaint);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Complaint deleted."),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
