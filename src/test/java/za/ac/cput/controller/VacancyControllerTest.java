package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VacancyControllerTest {
    private Recruiter recruiter = null;
    private String baseUrl;

    @Autowired
    private RecruiterController recruiterController;

    @LocalServerPort
    private int portNumber;

    @Autowired
    private TestRestTemplate restTemplate;

    public static String ADMIN_SECURITY_USERNAME = "admin";
    public static String ADMIN_SECURITY_PASSWORD = "721087c4-0ede-407e-8c1f-ac57e531f293";
    public static String USER_SECURITY_USERNAME = "user";
    public static String USER_SECURITY_PASSWORD = "721087c4-0ede-407e-8c1f-ac57e531f292";

    @BeforeEach
    void setUp()
    {
        Vacancy vacancy = VacancyFactory.build(12,"Informatics and Design", "Information and visual designing");
        recruiter = RecruiterFactory.build(6, "Science", "The field of study concerned with discovering and describing the world around us by observing and experimenting.", vacancy);
        baseUrl = "http://localhost:" + portNumber + "/" + "college-management-system/vacancy/";
    }

    @Order(1)
    @Test
    void save()
    {
        String url = baseUrl.concat("save");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Recruiter> entity = new HttpEntity<Recruiter>(recruiter, headers);
        ResponseEntity<Recruiter> response = null;

        response = restTemplate.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.POST, entity, Recruiter.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(2)
    @Test
    void read()
    {
        int recruiterId = 1;
        String url = baseUrl.concat("read/") + recruiterId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Recruiter> response = null;

        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, Recruiter.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Order(3)
    @Test
    void findAll()
    {
        String url = baseUrl.concat("find-all");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Recruiter[]> response = null;

        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, Recruiter[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length > 0);
    }

    @Order(4)
    @Test
    void deleteById()
    {
        int recruiterId = 6;
        String url = baseUrl.concat("delete-by-id/") + recruiterId;
        String readUrl = baseUrl.concat("read/") + recruiterId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Recruiter> response = null;

        restTemplate.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD).exchange(url, HttpMethod.DELETE, null, String.class);
        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(readUrl, HttpMethod.GET, entity, Recruiter.class);
        System.out.println(response);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Order(5)
    @Test
    @Disabled
    void delete()
    {
        String url = baseUrl.concat("delete");
        String readUrl = baseUrl.concat("read/") + recruiter.getRecruiterId();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Recruiter> response = null;

        restTemplate.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD).delete(url, recruiter, Recruiter.class);
        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(readUrl, HttpMethod.GET, entity, Recruiter.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
