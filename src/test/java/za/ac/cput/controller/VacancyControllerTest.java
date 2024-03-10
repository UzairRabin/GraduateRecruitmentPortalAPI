package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.factory.RecruiterFactory;
import za.ac.cput.factory.VacancyFactory;
import za.ac.cput.model.Recruiter;
import za.ac.cput.model.Vacancy;
import za.ac.cput.utility.Utility;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VacancyControllerTest {
    @Autowired
    private VacancyController controller;

    @LocalServerPort
    private int portNumber;

    @Autowired
    private TestRestTemplate restTemplate;

    private Vacancy vacancy;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        Recruiter recruiter = RecruiterFactory.build(Utility.generateId(), "John", "Smith", "Golden Minds", "john.smith@goldenminds.co.za" ,"021 541 3254", "12345", new HashSet<>(), "RECRUITER", LocalDate.now());
        vacancy = VacancyFactory.build(Utility.generateId(), "Full Stack Engineer", "Hybrid", "Graduate", false, "Johannesburg", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eos corrupti iure recusandae minima commodi voluptatem nostrum ab, reprehenderit eius possimus expedita laborum dicta, ipsum aut non, excepturi aspernatur sit error. Molestias officiis repellendus, accusamus omnis aliquid vero sequi soluta similique deserunt non rerum iusto saepe veniam nulla eveniet impedit aperiam.", "", new HashSet<>(), new HashSet<>(), recruiter);
        baseUrl = "http://localhost:" + portNumber + "/" + "api/v1/graduate-recruitment-portal-api/vacancy/";
    }

    @Test
    @Order(1)
    void save()
    {
        String url = baseUrl + "save";
        ResponseEntity<Vacancy> response = restTemplate.postForEntity(url, vacancy, Vacancy.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody()));
    }

    @Test
    @Order(2)
    void read()
    {
        long vacancyId = (restTemplate.getForEntity(baseUrl + "find-all", Vacancy[].class).getBody().length);
        String url = baseUrl + "read/" + vacancyId;
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
    @Disabled
    void delete()
    {
        String url = baseUrl + "delete";
        restTemplate.delete(url, vacancy, Vacancy.class);
    }

    @Test
    @Order(5)
    @Disabled
    void deleteById()
    {
        String url = baseUrl + "delete-by-id/" + vacancy.getVacancyId();
        ResponseEntity<Vacancy> response = restTemplate.getForEntity(url, Vacancy.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }
}
