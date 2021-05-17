package dai.educate.controller;

import dai.educate.model.VideoRight;

import dai.educate.response.ApiResponse;
import dai.educate.repository.VideoRightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class VideoRightController {

    @Autowired
    VideoRightRepository videoRightRepository;

    @GetMapping("/videorights")
    public List<VideoRight> listVideoRight(){
        return videoRightRepository.findAll();
    }

    @GetMapping("/videorights/{idVideo}")
    public VideoRight findVideoRight(@PathVariable long idVideo){
        return videoRightRepository.findVideoRightById(idVideo);
    }

    @PostMapping("/videorights")
    public ResponseEntity<ApiResponse> saveRight(@RequestBody VideoRight videoRight) {
        try {
            // Activity Attributes
            String linkVideo = videoRight.getLinkVideo();

            // Create Video Right
            VideoRight newVideoRight = new VideoRight(null, linkVideo);
            videoRightRepository.save(newVideoRight);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Video Right created"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/videorights/{idVideo}")
    public ResponseEntity<ApiResponse> deleteVideoRight(@PathVariable (value="idVideo")long idVideo) {
        try {
            VideoRight videoRight = videoRightRepository.findVideoRightById(idVideo);

            videoRightRepository.delete(videoRight);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Video Right deleted.", idVideo),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
