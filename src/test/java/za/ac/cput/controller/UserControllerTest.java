package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.model.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class UserControllerTest {

    private static User user1 = UserFactory
            .build("159753IR",
                    "IR2@gmail.com",
                    "Blue@1995",
                    "Manager");

    private static User user2 = UserFactory
            .build("#8529631",
                    "NewmanJ21@gmail.com",
                    "Josh4@192",
                    "Student");

    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String userURL = "http://localhost:8080/user";

    private String username = "user";
    private String password = "password";

    @Test
    void save01() {
        String url = userURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<User> httpEntity = new HttpEntity<>(user1, httpHeaders);
        ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, User.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        user1 = responseEntity.getBody();
        System.out.println("User Saved: "+user1);
        assertEquals(user1.getUserId(), responseEntity.getBody().getUserId());

    }

    @Test
    void save02() {
        String url = userURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<User> httpEntity = new HttpEntity<>(user2, httpHeaders);
        ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, User.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        user2 = responseEntity.getBody();
        System.out.println("User Saved: "+user2);
        assertEquals(user2.getUserId(), responseEntity.getBody().getUserId());

    }

    @Test
    void read() {
        User u = null;
        String url = userURL + "/read/" +user2.getUserId();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<User> request = new HttpEntity<>(u, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<User> responseCreate = restTemplate.postForEntity(url, request, User.class);
        assertNotNull(user2.getUserId(), responseCreate.getBody().getUserId());
    }

    @Test
    void delete() {
        String url = userURL + "/delete" + user1.getUserId();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void findAll() {
        String url = userURL + "/findAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                //basic config
                .withBasicAuth("user","password")
                .exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println("Display All Entries");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}