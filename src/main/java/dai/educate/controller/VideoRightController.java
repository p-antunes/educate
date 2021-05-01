package dai.educate.controller;

import dai.educate.model.Rights;
import dai.educate.model.VideoRight;

import dai.educate.payload.resonse.ApiResponse;
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

    @GetMapping("/videorights/{id_video}")
    public VideoRight findVideoRight(@PathVariable long id_video){
        return videoRightRepository.findVideoRightById(id_video);
    }

    @PostMapping("/videorights")
    public ResponseEntity<ApiResponse> saveRight(@RequestBody VideoRight videoRight) {
        try {
            // Activity Attributes
            String video_link = videoRight.getLink_video();

            // Create Video Right
            VideoRight newVideoRight = new VideoRight(null, video_link);
            videoRightRepository.save(newVideoRight);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Video Right created"),
                    HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/videorights/{id_video}")
    public ResponseEntity<ApiResponse> deleteVideoRight(@PathVariable (value="id_video")long id_video) {
        try {
            VideoRight videoRight = videoRightRepository.findVideoRightById(id_video);

            videoRightRepository.delete(videoRight);

            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Right deleted.", id_video),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Invalid data format"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
