package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.factory.ExperienceFactory;
import za.ac.cput.model.Experience;
import za.ac.cput.service.ExperienceServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/graduate-recruitment-portal-api/experience/")
public class ExperienceController {
    private final ExperienceServiceImpl experienceService;

    @Autowired
    public ExperienceController(ExperienceServiceImpl experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Experience> save(@Valid @RequestBody Experience experience) {
        Experience experienceSaved = null;
        try
        {
            experienceSaved = this.experienceService.save(experience);
        }catch (IllegalArgumentException exception)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(experienceSaved);
    }

    @GetMapping("read/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Experience> read(@PathVariable Long id) {
        Experience readExperience= this.experienceService.read(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Experience not found"));
        return ResponseEntity.ok(readExperience);
    }

    @DeleteMapping("delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(Experience experience) {
        this.experienceService.delete(experience);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.experienceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("find-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Experience>> findAll() {
        List<Experience> findAllTeamList = this.experienceService.findAll();
        return ResponseEntity.ok(findAllTeamList);
    }

}
