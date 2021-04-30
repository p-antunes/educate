package dai.educate.controller;

import dai.educate.model.VideoRight;

import dai.educate.repository.VideoRightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
