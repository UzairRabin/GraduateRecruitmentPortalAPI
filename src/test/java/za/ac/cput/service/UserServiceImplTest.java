package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.model.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class UserServiceImplTest {
//
    @Autowired
    private UserServiceImpl service;


    private final User user = UserFactory.build
            ("852963SQ",
                    "Swilson@gmail.com",
                    "Son12@94",
                    "Student");


    @Test
    void a_save() {
        User saved = service.save(user);
        assertEquals(saved.getUserId(), user.getUserId());
        System.out.println("saved" + saved);

    }

    @Test
    void b_read() {
        Optional<User> read = service.read(user.getUserId());
        assertNotNull(read);
        System.out.println("read:" + read);
    }

    @Test
    void c_delete() {
        this.service.delete(user);
        System.out.println("successfully deleted ");
    }

    @Test
    void d_findAll() {
        System.out.println("Display all");
        System.out.println(service.findAll());
    }
}