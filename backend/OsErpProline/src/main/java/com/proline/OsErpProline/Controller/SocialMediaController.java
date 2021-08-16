package com.proline.OsErpProline.Controller;

import com.proline.OsErpProline.Repository.EmployeeRepository;
import com.proline.OsErpProline.Repository.SocialMediaRepository;
import com.proline.OsErpProline.entity.Employee;
import com.proline.OsErpProline.entity.Socialmedia;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialMediaController {
    private final SocialMediaRepository socialMediaRepository;

    public SocialMediaController(SocialMediaRepository socialMediaRepository) {
        this.socialMediaRepository = socialMediaRepository;
    }

    @GetMapping("/socialmedia")
    List<Socialmedia> all() {
        return socialMediaRepository.findAll();
    }

    @PostMapping("/socialmedia")
    Socialmedia newSocialmedia(@RequestBody Socialmedia newSocialmedia){
        return socialMediaRepository.save(newSocialmedia);
    }

    @DeleteMapping("/socialmedida/platform")
    void deleteEmployee(@PathVariable String platform) {
        socialMediaRepository.deleteById(platform);
    }
}
