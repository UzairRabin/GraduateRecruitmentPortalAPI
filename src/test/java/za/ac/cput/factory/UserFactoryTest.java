package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.model.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {
//
    @Test
    void build() {

        User user = UserFactory.build(
                "87521QE",
                "coleman@gmail.com",
                "CM@2022",
                "Employee");
        System.out.println(user.toString());
        assertNotNull(user);

    }
}