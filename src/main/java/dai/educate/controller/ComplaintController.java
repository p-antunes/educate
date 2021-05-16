package dai.educate.controller;

import dai.educate.model.Complaint;
import dai.educate.model.Create.CreateComplaint;
import dai.educate.model.Report;
import dai.educate.model.Role;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.*;
import dai.educate.security.CurrentUser;
import dai.educate.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ComplaintController {

    @Autowired
    ComplaintRepository complaintRepository;

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

    @GetMapping("/complaints")
    public List<Complaint> listComplaint() {
        return complaintRepository.findAll();
    }

    @GetMapping("/complaints/{idComplaint}")
    public Complaint findComplaint( @PathVariable long idComplaint) {
        return complaintRepository.findByIdComplaint(idComplaint);
    }

    @PostMapping("/complaints")
    public ResponseEntity<ApiResponse> saveComplaint(@CurrentUser UserPrincipal currentUser, @RequestBody CreateComplaint comp) {
        try {

            String email = currentUser.getEmail();
            Role role = loginRepository.findDistinctByEmail(email).getRole();
            Long idUser = currentUser.getId();
            Date date = new Date(System.currentTimeMillis());

            String title = comp.getTitle();
            String complaint = comp.getComplaint();

            if (role.getIdRole() == 1) {
                String name = childRepository.findDistinctByIdChild(idUser).getName();
                String county = childRepository.findDistinctByIdChild(idUser).getCounty();
                String city = childRepository.findDistinctByIdChild(idUser).getCity();
                String address = childRepository.findDistinctByIdChild(idUser).getAddress();
                String postCode = childRepository.findDistinctByIdChild(idUser).getPostalCode();

                Complaint newComplaint = new Complaint(null, date, title, complaint, name, null, county, city, address, postCode);
                complaintRepository.save(newComplaint);

                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Complaint created successfully"), HttpStatus.CREATED);
            }
            if (role.getIdRole() == 2) {
                String name = teenagerRepository.findDistinctByIdTeenager(idUser).getName();
                String county = teenagerRepository.findDistinctByIdTeenager(idUser).getCounty();
                String city = teenagerRepository.findDistinctByIdTeenager(idUser).getCity();
                String address = teenagerRepository.findDistinctByIdTeenager(idUser).getAddress();
                String phoneNr = teenagerRepository.findDistinctByIdTeenager(idUser).getPhoneNr();
                String postCode = teenagerRepository.findDistinctByIdTeenager(idUser).getPostalCode();

                Complaint newComplaint = new Complaint(null, date, title, complaint, name, phoneNr, county, city, address, postCode);
                complaintRepository.save(newComplaint);

                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Complaint created successfully"), HttpStatus.CREATED);
            }
            if (role.getIdRole() == 3) {
                String name = familyRepository.findDistinctByIdFamily(idUser).getName();
                String county = familyRepository.findDistinctByIdFamily(idUser).getCounty();
                String city = familyRepository.findDistinctByIdFamily(idUser).getCity();
                String address = familyRepository.findDistinctByIdFamily(idUser).getAddress();
                String phoneNr = familyRepository.findDistinctByIdFamily(idUser).getPhoneNr();
                String postCode = familyRepository.findDistinctByIdFamily(idUser).getPostalCode();

                Complaint newComplaint = new Complaint(null, date, title, complaint, name, phoneNr, county, city, address, postCode);
                complaintRepository.save(newComplaint);

                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Complaint created successfully"),
                        HttpStatus.CREATED);

            }
            if (role.getIdRole() == 4) {
                String name = institutionRepository.findDistinctByIdInstitution(idUser).getName();
                String county = institutionRepository.findDistinctByIdInstitution(idUser).getCounty();
                String city = institutionRepository.findDistinctByIdInstitution(idUser).getCity();
                String address = institutionRepository.findDistinctByIdInstitution(idUser).getAddress();
                String postCode = institutionRepository.findDistinctByIdInstitution(idUser).getPostalCode();

                Complaint newComplaint = new Complaint(null, date, title, complaint, name, null, county, city, address, postCode);
                complaintRepository.save(newComplaint);

                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Complaint created successfully"), HttpStatus.CREATED);
            }
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }}

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
