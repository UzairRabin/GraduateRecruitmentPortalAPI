package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.model.Recruiter;
import za.ac.cput.model.Vacancy;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VacancyControllerTest {
    @Autowired
    private VacancyController controller;

    @LocalServerPort
    private int portNumber;

    @Autowired
    private TestRestTemplate restTemplate;

    private Vacancy employeeAddress;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        Recruiter recruiter = RecruiterFactory.build(6, "John Smith", "Golden Minds", "021 541 3254", LocalDate.now());
        Vacancy vacancy = VacancyFactory.build(12,"Full Stack Engineer", "Hybrid", "Graduate", false, "Johannesburg", recruiter);
        baseUrl = "http://localhost:" + portNumber + "/" + "graduate-recruitment-portal-api/vacancy/";
    }

    @Test
    @Order(1)
    void save()
    {
        String url = baseUrl + "save";
        ResponseEntity<Vacancy> response = restTemplate.postForEntity(url, employeeAddress, Vacancy.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
                 );
    }

    @Test
    @Order(2)
    void read()
    {
        String url = baseUrl + "read/" + employeeAddress.getStaffId();
        ResponseEntity<Vacancy> response = restTemplate.getForEntity(url, Vacancy.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
                 );
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = baseUrl + "find-all";
        ResponseEntity<Vacancy[]> response = restTemplate.getForEntity(url, Vacancy[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length > 0)
                 );
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = baseUrl + "delete";
        restTemplate.delete(url, employeeAddress, Vacancy.class);
    }

    @Test
    @Order(5)
    @Disabled
    void deleteById()
    {
        String url = baseUrl + "delete-by-id/" + employeeAddress.getStaffId();
        ResponseEntity<Vacancy> response = restTemplate.getForEntity(url, Vacancy.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }
}
