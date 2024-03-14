package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.exception.NotRegisteredUserException;
import za.ac.cput.exception.PasswordMismatchException;
import za.ac.cput.exception.UserExistsException;
import za.ac.cput.factory.UserSessionFactory;
import za.ac.cput.model.Graduate;
import za.ac.cput.model.Recruiter;
import za.ac.cput.model.UserSession;
import za.ac.cput.model.Vacancy;
import za.ac.cput.service.GraduateServiceImpl;
import za.ac.cput.serviceFacade.UserAuthenticatorServiceFacadeImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


/**
 * @author Chuma Nxazonke
 * Date: 25 November 2022
 * */
@RestController
@RequestMapping("api/v1/graduate-recruitment-portal-api/graduate/")
@Slf4j
public class GraduateController {

    private final GraduateServiceImpl graduateServiceImpl;

    @Autowired
    GraduateController(GraduateServiceImpl graduateServiceImpl)
    {
        this.graduateServiceImpl = graduateServiceImpl;
    }

    //Working Endpoint
    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Graduate> save(@RequestBody Graduate graduate)
    {
        Graduate save = null;

        try{
            save = this.graduateServiceImpl.save(graduate);
        }
        catch(IllegalArgumentException exception)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(save);
    }

    //working Endpoint
    @GetMapping("read/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Graduate> read(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        Graduate graduate = graduateServiceImpl.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(graduate);
    }

    //working endpoint
    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Graduate> delete(@PathVariable String id)
    {
        log.info("Delete Request: {}", id);
        this.graduateServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("find-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Graduate>> findAll()
    {
        return ResponseEntity.ok(this.graduateServiceImpl.findAll());
    }

    @PostMapping("login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserSession> login(@RequestBody Graduate graduate)
    {
        UserSession userSession = null;
        try{
            userSession = graduateServiceImpl.login(graduate);
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
    public ResponseEntity<Graduate> signup(@RequestBody Graduate graduate)
    {
        Graduate user = null;
        try{
            user = this.graduateServiceImpl.signup(graduate);
        }
        catch(IllegalArgumentException | UserExistsException exception)
        {
            if(exception instanceof UserExistsException)
                throw new ResponseStatusException(HttpStatus.OK, ((UserExistsException) exception).getLocalizedMessage());
            else throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(user);
    }
}