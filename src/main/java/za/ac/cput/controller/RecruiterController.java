package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.exception.NotRegisteredUserException;
import za.ac.cput.exception.PasswordMismatchException;
import za.ac.cput.factory.UserSessionFactory;
import za.ac.cput.model.Graduate;
import za.ac.cput.model.Recruiter;
import za.ac.cput.model.UserSession;
import za.ac.cput.service.IRecruiterService;
import za.ac.cput.service.RecruiterServiceImpl;
import za.ac.cput.serviceFacade.UserAuthenticatorServiceFacadeImpl;

import java.util.List;

/**
 * @author Mbuso Kotobe
 * */
@RestController
@RequestMapping("api/v1/graduate-recruitment-portal-api/recruiter/")
@Slf4j
public class RecruiterController {
    private final RecruiterServiceImpl service;

    @Autowired
    RecruiterController(RecruiterServiceImpl service){this.service = service;}

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
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
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Recruiter> read(@PathVariable String recruiterId) {
        log.info("Read request:{}", recruiterId);
        Recruiter read = this.service.read(recruiterId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found"));
        return ResponseEntity.ok(read);
    }

    @GetMapping("find-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Recruiter>>findAll(){List<Recruiter> recruiter = this.service.findAll();
        return ResponseEntity.ok(recruiter);}

    @DeleteMapping("delete/{recruiterId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> deleteById(@PathVariable String recruiterId) {service.deleteById(recruiterId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(Recruiter recruiter) {this.service.delete(recruiter);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserSession> login(@RequestBody Recruiter recruiter)
    {
        UserSession userSession = null;
        try{
            userSession = service.login(recruiter);
            return ResponseEntity.ok(userSession);
        }
        catch (NotRegisteredUserException | PasswordMismatchException exception)
        {
            if(exception instanceof NotRegisteredUserException)
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ((NotRegisteredUserException) exception).getMessage());
            else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, exception.getLocalizedMessage());
        }
    }

    @PostMapping("signup")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Recruiter> signup(@RequestBody Recruiter recruiter)
    {
        Recruiter user = null;
        try{
            user = this.service.signup(recruiter);
        }
        catch(IllegalArgumentException exception)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(user);
    }
}


