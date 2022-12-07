package za.ac.cput.service;

import org.junit.jupiter.api.*;
import za.ac.cput.factory.GraduateFactory;
import za.ac.cput.model.Graduate;
import za.ac.cput.repository.IGraduateRepository;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187

 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GraduateServiceImplTest {


    private IGraduateRepository repository;

    private GraduateServiceImpl service;

    private Graduate graduate;

    @BeforeEach
    void setUp() {
        this.service = new GraduateServiceImpl(repository);
        Graduate graduate = GraduateFactory.createGraduateFactory("B1254","Chuma", "Edward",
                "Nxazonke", "219181187@mycput.ac.za", "chumaedward1569@gmail.com",
                "Mchumane19954@",
                "0847622511" + experience + qualification + cv);

        assertNotNull(graduate);
    }

    @Test
    @Order(1)
    void save() {
        Graduate save = this.repository.save(this.graduate);
        assertEquals(this.graduate, save);
    }

    @Test
    @Order(2)
    void read() {
        Graduate read = this.repository.getById(this.graduate.getGraduateId());
        assertEquals(this.graduate, read);
    }

    @Test
    @Order(3)
    void update() {
        Graduate update = this.repository.getById(this.graduate.getGraduateId());
        assertEquals(this.graduate, update);
    }

    @Test
    @Order(5)
    void delete() {
        this.repository.deleteById(this.graduate.getGraduateId());
        Set<Graduate> graduateSet = this.repository.findAll().stream().collect(Collectors.toSet());
        assertSame(0, graduateSet.size());
    }

    @Test
    @Order(4)
    void getAll() {
        Set<Graduate> graduateSet = this.repository.findAll().stream().collect(Collectors.toSet());
        assertSame(1, graduateSet.size());
    }

}

