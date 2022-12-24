package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.factory.QualificationFactory;
import za.ac.cput.model.Qualification;
import za.ac.cput.service.IQualificationService;

import java.util.List;
@RestController
@RequestMapping("api/v1/graduate-recruitment-portal-api/qualification/")
@Slf4j

public class QualificationController {
    private final IQualificationService qualificationService;

    @Autowired
    public QualificationController(IQualificationService qualificationService){
        this.qualificationService = qualificationService;
    }

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Qualification> save(@RequestBody Qualification qualification){
        log.info("Save request: {}", qualification);

        Qualification validatedQualification;
        try{
            validatedQualification = qualificationService.save(qualification);
        }catch(IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(validatedQualification);
    }

    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.qualificationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Qualification> read (@PathVariable String id){
        log.info("Read request: {}", id);
        Qualification qualification = this.qualificationService.read(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(qualification);
    }

    @GetMapping("read-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Qualification>> readAll(){
        List<Qualification> qualificationList = this.qualificationService.findAll();
        return ResponseEntity.ok(qualificationList);
    }
}
