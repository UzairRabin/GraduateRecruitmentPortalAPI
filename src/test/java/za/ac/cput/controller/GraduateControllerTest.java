//package za.ac.cput.controller;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import za.ac.cput.factory.GraduateFactory;
//import za.ac.cput.model.Cv;
//import za.ac.cput.model.Experience;
//import za.ac.cput.model.Graduate;
//import za.ac.cput.model.Qualification;
//
//
//import java.util.Arrays;
//import java.util.Objects;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//
///**
// * @author Chuma Nxazonke
// * Student number: 219181187
// */
//
//
//class GraduateControllerTest {
//
//    @LocalServerPort
//    private int portNumber;
//
//
//    private GraduateController graduateController;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    private Graduate graduate;
//    private Experience experience;
//    private Qualification qualification;
//    private Cv cv;
//
//    private String urlBase;
//
//    GraduateControllerTest()
//    {
//    }
//
//    @BeforeEach
//    void setUp()
//    {
//        assertNotNull(graduateController);
//        Graduate graduate = GraduateFactory.createGraduateFactory("B1254","Chuma", "Edward",
//                "Nxazonke", "219181187@mycput.ac.za", "chumaedward1569@gmail.com",
//                "Mchumane19954@",
//                "0847622511" + experience + qualification + cv);
//
//
//
//        this.urlBase = "http://localhost:" + this.portNumber + "/graduate-recrutment-portal/graduate/";
//    }
//
//
//    @Test
//    @Order(1)
//    void save()
//    {
//        String url = urlBase + "save/graduate";
//        System.out.println(url);
//
//        ResponseEntity<Graduate> graduateResponseEntity = this.restTemplate.postForEntity(url, this.graduate, Graduate.class);
//        System.out.println(graduateResponseEntity);
//
//        assertAll(()-> assertEquals(HttpStatus.OK, graduateResponseEntity.getStatusCode()),
//                ()-> assertNotNull(graduateResponseEntity.getBody()));
//        System.out.println("Graduate saved!");
//    }
//
//    @Test
//    @Order(2)
//    void read()
//    {
//        String url = urlBase + "getAdmin/"+graduate.getGraduateId();
//        System.out.println(url);
//
//        ResponseEntity<Graduate> graduateResponseEntity = this.restTemplate.getForEntity(url,Graduate.class);
//        System.out.println(graduateResponseEntity);
//
//        assertAll(()-> assertEquals(HttpStatus.OK,graduateResponseEntity.getStatusCode()),
//                ()-> assertNotNull(graduateResponseEntity.getBody()));
//    }
//
//    @Test
//    @Order(3)
//    void update(){
//        String url = urlBase + "updateGraduate/"+graduate.getGraduateId();
//        System.out.println(url);
//
//        ResponseEntity<Graduate> graduateResponseEntity = this.restTemplate.getForEntity(url,Graduate.class);
//        System.out.println(graduateResponseEntity);
//
//        assertAll(()-> assertEquals(HttpStatus.OK,graduateResponseEntity.getStatusCode()),
//                ()-> assertNotNull(graduateResponseEntity.getBody()));
//
//        System.out.println("Graduate record updated successfully");
//
//    }
//
//
//    @Test
//    @Order(5)
//    void delete()
//    {
//        String url = urlBase + "deleteGraduate/"+graduate.getGraduateId();
//        System.out.println(url);
//
//        assertAll(()->assertSame("1",graduate.getGraduateId()),
//                ()->assertNotNull(graduate.getFirstName()));
//        System.out.println("Delete successful!");
//    }
//
//    @Test
//    @Order(4)
//    void getAll()
//    {
//        String url = urlBase + "getAll/graduate";
//        System.out.println(url);
//
//        ResponseEntity<Graduate[]> responseEntity =this.restTemplate.getForEntity(url, Graduate[].class);
//        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));
//
//        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
//                ()-> assertTrue(responseEntity.getBody().length == 0),
//                ()-> assertNotNull(responseEntity));
//    }
//
//
//}