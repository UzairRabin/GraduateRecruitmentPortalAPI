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
@RequestMapping("api/v1/graduate-portal/department/")
@Slf4j
public class DepartmentController {

    private final IDepartmentService departmentService;

    @Autowired
    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("save")
    public ResponseEntity<Department> save(@Valid @RequestBody Department department){
        log.info("Save request:{}", department);
        Department departments;
        try{
            departments = DepartmentFactory.build(department.getDepartmentId(), department.getDepartmentName());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        Department save = this.departmentService.save(department);
        return ResponseEntity.ok(save);
    }

    private Optional<Department> getById(int departmentId){
        return this.departmentService.read(departmentId);
    }

    @GetMapping("read/{departmentId}")
    public ResponseEntity<Department> read(@PathVariable int departmentId) {
        log.info("Read request:{}", departmentId);
        Department readDept= this.departmentService.read(departmentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found"));
        return ResponseEntity.ok(readDept);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Department department) {
        this.departmentService.delete(department);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{departmentId}")
    public ResponseEntity<Void> delete(@PathVariable int departmentId) {
        log.info("delete request:{}",departmentId);
        //System.out.println("delete" +""+ departmentId);
        Optional<Department> department  = getById(departmentId);
        department.ifPresent(this.departmentService::delete);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Department>> getAll() {
        List<Department> department = this.departmentService.getAll();
        return ResponseEntity.ok(department);
    }
}
