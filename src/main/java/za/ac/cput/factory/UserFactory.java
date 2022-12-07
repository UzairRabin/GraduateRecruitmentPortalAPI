package za.ac.cput.factory;

import za.ac.cput.model.User;
import za.ac.cput.utility.Utility;

public class UserFactory {

    public static User build (String userId, String email, String password, String userRole){

        Utility.checkStringParam("userId", (userId));
        Utility.checkStringParam("email", email);
        Utility.checkStringParam("password", password);
        Utility.checkStringParam("userRole", userRole);

        return new User.Builder().setUserId(userId)
                .setEmail(email)
                .setPassword(password)
                .setUserRole(userRole)
                .build();

    }




}
