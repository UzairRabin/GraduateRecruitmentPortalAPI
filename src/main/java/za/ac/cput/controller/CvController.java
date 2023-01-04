/*
Author: Tiffany Kiwiets
Controller for Cv
 */
package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.factory.CvFactory;
import za.ac.cput.model.Cv;
import za.ac.cput.service.ICvService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/graduate-recruitment-portal-api/cv/")
@Slf4j
public class CvController {

    private final ICvService cvService;

    @Autowired
    CvController(ICvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Cv> save(@RequestParam MultipartFile cv, @RequestParam String username)
    {
        log.info("Save CV request:{}", cv);
        Cv requestResult = this.cvService.save(cv, username);
        return ResponseEntity.ok(requestResult);
    }

    @GetMapping("read/{cvId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Cv> read(@PathVariable String cvId) {
        log.info("Read request:{}", cvId);
        Cv read = this.cvService.read(cvId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CV not found"));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(Cv cv) {
        this.cvService.delete(cv);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Cv>> findAll() {
        List<Cv> cv = this.cvService.findAll();
        return ResponseEntity.ok(cv);
    }

}