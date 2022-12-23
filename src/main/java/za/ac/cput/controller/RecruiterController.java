package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.model.Recruiter;
import za.ac.cput.service.IRecruiterService;

import java.util.List;

@RestController
@RequestMapping("api/v1/graduate-recruitment-portal-api/recruiter/")
@Slf4j
public class RecruiterController {
    private final IRecruiterService service;

    @Autowired
    RecruiterController(IRecruiterService service){this.service = service;}

    @PostMapping("save")
    public ResponseEntity<Recruiter> save(@RequestBody Recruiter recruiter){
        Recruiter recruiterReturned = null;
        try{
            recruiterReturned = service.save(recruiter);
        }
        catch (IllegalArgumentException exception)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(recruiterReturned);
    }

    @GetMapping("read/{recruiterId}")
    public ResponseEntity<Recruiter> read(@PathVariable long recruiterId) {
        log.info("Read request:{}", recruiterId);
        Recruiter read = this.service.read(recruiterId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found"));
        return ResponseEntity.ok(read);
    }

    @GetMapping("all")
    public ResponseEntity<List<Recruiter>>findAll(){List<Recruiter> recruiter = this.service.findAll();
        return ResponseEntity.ok(recruiter);}

    @DeleteMapping("delete/{recruiterId}")
    public ResponseEntity<Void> deleteById(@PathVariable long recruiterId) {service.deleteById(recruiterId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Recruiter recruiter) {this.service.delete(recruiter);
        return ResponseEntity.noContent().build();
    }
}


