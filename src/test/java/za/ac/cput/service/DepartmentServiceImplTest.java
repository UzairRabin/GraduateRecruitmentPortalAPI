package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.factory.DepartmentFactory;
import za.ac.cput.model.Department;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Chadrack Mbuyi
 * */

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j
class DepartmentServiceImplTest {

    @Autowired
    protected DepartmentServiceImpl service;

    Department departmentService = DepartmentFactory.build(2,"IT Department");

    @Test
    void a_save() {
        Department departmentService1 = this.service.save(departmentService);
        Department departmentService = this.service.save(departmentService1);
        log.info(departmentService1.toString());
        log.info(departmentService.toString());
    }

    @Test
    void b_read() {
        Optional<Department> temp = this.service.read(1);
        log.info(temp.toString());
    }

    @Test
    void d_delete() {
        this.service.delete(departmentService);
    }

    @Test
    void c_getAll() {
        List<Department> list = this.service.getAll();

        log.info(list.toString());
    }
}