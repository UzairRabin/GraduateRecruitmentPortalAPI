package za.ac.cput.factory;



import za.ac.cput.model.Cv;
import za.ac.cput.model.Experience;
import za.ac.cput.model.Graduate;
import za.ac.cput.model.Qualification;

import za.ac.cput.utility.Utility;

import java.util.Set;


/**
 * @author Chuma Nxazonke
 * Date: 23 November 2022
 * */

public class GraduateFactory {

    public static Graduate build(String firstName, String preferredName, String surname, String primaryEmail, String secondaryEmail, String password, String cellphone, String userRole, Cv cv, Set<Qualification> qualification, Set<Experience> experience) throws IllegalArgumentException
    {
        Utility.checkStringParam("firstName", firstName);
        Utility.checkStringParam("preferredName", preferredName);
        Utility.checkStringParam("surname", surname);
        Utility.checkStringParam("primaryEmail", primaryEmail);
        Utility.checkStringParam("secondaryEmail", secondaryEmail);
        Utility.checkStringParam("password", password);
        Utility.checkStringParam("cellphone", cellphone);
        Utility.checkStringParam("userRole", userRole);

        return Graduate.builder()
                .firstName(firstName)
                .preferredName(preferredName)
                .surname(surname)
                .email(primaryEmail)
                .secondaryEmail(secondaryEmail)
                .password(password)
                .cellphone(cellphone)
                .userRole(userRole)
                .cv(cv)
                .qualifications(qualification)
                .experiences(experience).build();

    }
}