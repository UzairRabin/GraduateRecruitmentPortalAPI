package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.factory.DepartmentFactory;
import za.ac.cput.model.Department;
import za.ac.cput.model.Experience;
import za.ac.cput.service.IDepartmentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/graduate-recruitment-portal-api/department/")
@Slf4j
public class DepartmentController {

    private final IDepartmentService departmentService;

    @Autowired
    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Department> save(@Valid @RequestBody Department department)
    {
        log.info("Save request:{}", department);
        Department departments;
        try{
            departments = this.departmentService.save(department);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        return ResponseEntity.ok(departments);
    }

    @GetMapping("read/{departmentId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Department> read(@PathVariable String departmentId) {
        log.info("Read request:{}", departmentId);
        Department readDept= this.departmentService.read(departmentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found"));
        return ResponseEntity.ok(readDept);
    }

    @DeleteMapping("delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(Department department) {
        this.departmentService.delete(department);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{departmentId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable String departmentId) {
        log.info("delete request:{}",departmentId);
        this.departmentService.deleteById(departmentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("find-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Department>> findAll() {
        return ResponseEntity.ok(this.departmentService.findAll());
    }
}
