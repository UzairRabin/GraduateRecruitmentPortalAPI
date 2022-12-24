package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.model.Vacancy;
import za.ac.cput.service.IVacancyService;

import java.util.List;

@RestController
@RequestMapping("api/v1/graduate-recruitment-portal-api/vacancy/")
@Slf4j
public class VacancyController {
    private final IVacancyService service;

    @Autowired
    public VacancyController (IVacancyService service)
    {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Vacancy> save(@RequestBody Vacancy vacancy)
    {
        Vacancy vacancyReturned = null;
        try{
            vacancyReturned = service.save(vacancy);
        }
        catch(IllegalArgumentException excpetion)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(vacancyReturned);
    }

    @GetMapping("read/{vacancyId}")
    public ResponseEntity<Vacancy> read(@PathVariable long vacancyId)
    {
        Vacancy vacancyReturned = service.read(vacancyId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(vacancyReturned);
    }

    @GetMapping("find-all")
    public ResponseEntity<List<Vacancy>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("delete/{vacancyId}")
    public ResponseEntity<Void> deleteById(@PathVariable long vacancyId)
    {
        service.deleteById(vacancyId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody Vacancy vacancy)
    {
        service.delete(vacancy);
        return ResponseEntity.noContent().build();
    }
}

