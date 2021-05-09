package dai.educate.controller;

import dai.educate.model.Create.CreateReport;
import dai.educate.model.Report;

import dai.educate.model.Rights;
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
public class ReportController {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    ChildRepository childRepository;

    @Autowired
    TeenagerRepository teenagerRepository;

    @Autowired
    FamilyRepository familyRepository;

    @GetMapping("/reports")
    public List<Report> listReport() {
        return reportRepository.findAll();
    }

    @GetMapping("/reports/{idReport}")
    public Report findReport(@PathVariable long idReport) {
        return reportRepository.findByIdReport(idReport);
    }

    @PostMapping("/reports")
    public ResponseEntity<ApiResponse> saveReport(@CurrentUser UserPrincipal currentUser, @RequestBody CreateReport rep) {
        try {
            String email = currentUser.getEmail();
            Role role = loginRepository.findDistinctByEmail(email).getRole();
            Long idUser = loginRepository.findDistinctByEmail(email).getIdLogin();
            Date date = new Date(System.currentTimeMillis());

            String title = rep.getTitle();
            String description = rep.getDescription();

            if (role.getIdRole() == 1) {
                String name = childRepository.findDistinctByIdChild(idUser).getName();
                String county = childRepository.findDistinctByIdChild(idUser).getCounty();
                String city = childRepository.findDistinctByIdChild(idUser).getCity();
                String address = childRepository.findDistinctByIdChild(idUser).getAddress();

                Report newReport = new Report(null, date, title, description, name, email, null, county, city, address);
                reportRepository.save(newReport);

                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Report created"), HttpStatus.CREATED);
            }
            if (role.getIdRole() == 2) {
                String nameTeen = teenagerRepository.findDistinctByIdTeenager(idUser).getName();
                String countyTeen = teenagerRepository.findDistinctByIdTeenager(idUser).getCounty();
                String cityTeen = teenagerRepository.findDistinctByIdTeenager(idUser).getCity();
                String addressTeen = teenagerRepository.findDistinctByIdTeenager(idUser).getAddress();
                String phoneNr = teenagerRepository.findDistinctByIdTeenager(idUser).getPhoneNr();

                Report nReport = new Report(null, date, title, description, nameTeen, email, phoneNr, countyTeen, cityTeen, addressTeen);
                reportRepository.save(nReport);

                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Report created"), HttpStatus.CREATED);
            }
            if (role.getIdRole() == 3) {
                String name = familyRepository.findDistinctByIdFamily(idUser).getName();
                String county = familyRepository.findDistinctByIdFamily(idUser).getCounty();
                String city = familyRepository.findDistinctByIdFamily(idUser).getCity();
                String address = familyRepository.findDistinctByIdFamily(idUser).getAddress();
                String phoneNr = familyRepository.findDistinctByIdFamily(idUser).getPhoneNr();

                Report newReport = new Report(null, date, title, description, name, email, phoneNr, county, city, address);
                reportRepository.save(newReport);

                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Report created"), HttpStatus.CREATED);
            }
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }

    }
}

