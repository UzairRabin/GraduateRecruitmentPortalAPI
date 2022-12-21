package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.model.Graduate;
import za.ac.cput.service.GraduateServiceImpl;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/graduate-recrutment-portal/graduate/")
@Slf4j



/**
 * @author Chuma Nxazonke
 * Date: 25 November 2022
 * */
public class GraduateController {

    private GraduateServiceImpl graduateServiceImpl;

    @Autowired
    GraduateController(GraduateServiceImpl graduateServiceImpl)
    {
        this.graduateServiceImpl = graduateServiceImpl;
    }

    @PostMapping("saveGraduate/graduate")
    public ResponseEntity<Graduate> save(@Valid @RequestBody Graduate graduate)
    {
        log.info("Save Request: {}", graduate);
        Graduate save = this.graduateServiceImpl.saveGraduate(graduate);
        return ResponseEntity.ok(save);
    }

    @GetMapping("getGraduate/{id}")
    public ResponseEntity<Graduate> read(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        try
        {
            Graduate read = this.graduateServiceImpl.readGraduate(id);
            return ResponseEntity.ok(read);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
/**
    @PutMapping("/update")
    public Graduate updateGraduate (@RequestBody Graduate graduate){
        return graduateServiceImpl.updateGraduate(graduate);
    }
**/

    @DeleteMapping("deleteGraduate/{id}")
    public ResponseEntity<Graduate> delete(@PathVariable String id)
    {
        log.info("Delete Request: {}", id);
        this.graduateServiceImpl.deleteGraduate(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll/graduate")
    public ResponseEntity<Set<Graduate>> getAll()
    {
        Set<Graduate> administrationSet = this.graduateServiceImpl.getAll();
        return ResponseEntity.ok(administrationSet);
    }


}

