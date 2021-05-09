package dai.educate.controller;
/*
import dai.educate.model.Report;

import dai.educate.model.Rights;
import dai.educate.payload.response.ApiResponse;
import dai.educate.repository.ReportRepository;
import dai.educate.security.CurrentUser;
import dai.educate.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public class ReportController {

    @Autowired
    ReportRepository reportRepository;

    @GetMapping("/reports")
    public List<Report> listReport(){
        return reportRepository.findAll();
    }

    @GetMapping("/reports/{idReport}")
    public Report findReport(@PathVariable long idReport){
        return reportRepository.findByIdReport(idReport);
    }

    @PostMapping("/reports")
    public ResponseEntity<ApiResponse> saveReport(@CurrentUser UserPrincipal currentUser) {
        try {
            String email = currentUser.getEmail();
            String phoneNr = currentUser.

            Date init_data  = activity.getInit_data();
            Date end_data  = activity.getEnd_data();
            String title = activity.getTitle();
            String status = "Por aprovar";
            String address = activity.getAddress();
            int spaces = activity.getSpaces();
            Institution institution = institutionRepository.findDistinctByIdInstitution(activity.getIdInstitution());
            ActivityType activityType = activityTypeRepository.findDistinctByIdActivityType(activity.getIdActivityType());

            if(!currentUser.getId().equals(activity.getIdInstitution())){
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Não tem acesso."),
                        HttpStatus.BAD_REQUEST);
            }

            if (init_data.compareTo(end_data) >0 || ! status.equals("Por aprovar")) {
                return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                        HttpStatus.BAD_REQUEST);
            } else {
                Activity Activity = new Activity(null,institution,activityType,null,status,init_data,end_data,address,title,0,spaces);
                activityRepository.save(Activity);
                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Activity created", Activity.getIdActivity()),
                        HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
*/