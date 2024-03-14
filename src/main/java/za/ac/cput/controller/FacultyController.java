package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.model.Faculty;
import za.ac.cput.service.IFacultyService;

import java.util.List;

/**
 * @author Mbuso Kotobe
 * */
@RestController
@RequestMapping("api/v1/graduate-recruitment-portal-api/faculty/")
@Slf4j
public class FacultyController {
    private final IFacultyService service;

    @Autowired
    public FacultyController (IFacultyService service)
    {
        this.service = service;
    }

    //working endpoint
    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Faculty> save(@RequestBody Faculty faculty)
    {
        Faculty facultyReturned = null;
        try{
            facultyReturned = service.save(faculty);
        }
        catch(IllegalArgumentException excpetion)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(facultyReturned);
    }

    @GetMapping("read/{facultyId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Faculty> read(@PathVariable String facultyId)
    {
        Faculty facultyReturned = service.read(facultyId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(facultyReturned);
    }

    @GetMapping("find-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Faculty>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("delete/{facultyId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> deleteById(@PathVariable String facultyId)
    {
        service.deleteById(facultyId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@RequestBody Faculty faculty)
    {
        service.delete(faculty);
        return ResponseEntity.noContent().build();
    }
}
