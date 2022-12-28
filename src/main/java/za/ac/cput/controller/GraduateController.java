package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.model.Graduate;
import za.ac.cput.model.Vacancy;
import za.ac.cput.service.GraduateServiceImpl;

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

    @PostMapping("save")
    public ResponseEntity<Graduate> save(@Valid @RequestBody Graduate graduate)
    {
        log.info("Save Request: {}", graduate);
        Graduate save = this.graduateServiceImpl.save(graduate);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Graduate> read(@PathVariable Long id)
    {
        log.info("Read Request: {}", id);
        Graduate graduate = graduateServiceImpl.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(graduate);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Graduate> delete(@PathVariable Long id)
    {
        log.info("Delete Request: {}", id);
        this.graduateServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("find-all")
    public ResponseEntity<List<Graduate>> findAll()
    {
        return ResponseEntity.ok(this.graduateServiceImpl.findAll());
    }
}

