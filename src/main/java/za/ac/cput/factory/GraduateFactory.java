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

    public static Graduate build(String userId, String firstName, String preferredName, String surname, String primaryEmail, String secondaryEmail, String password, String cellphone, String userRole, String motorVehicleLicense, String country, Cv cv, Set<Qualification> qualification, Set<Experience> experience) throws IllegalArgumentException
    {
        Utility.checkStringParam("userId", userId);
        Utility.checkStringParam("firstName", firstName);
        Utility.checkStringParam("preferredName", preferredName);
        Utility.checkStringParam("surname", surname);
        Utility.checkStringParam("primaryEmail", primaryEmail);
        Utility.checkStringParam("secondaryEmail", secondaryEmail);
        Utility.checkStringParam("password", password);
        Utility.checkStringParam("cellphone", cellphone);
        Utility.checkStringParam("country", country);
        Utility.checkStringParam("userRole", userRole);

        return Graduate.builder()
                .userId(userId)
                .firstName(firstName)
                .preferredName(preferredName)
                .surname(surname)
                .email(primaryEmail)
                .secondaryEmail(secondaryEmail)
                .password(password)
                .cellphone(cellphone)
                .motorVehicleLicense(motorVehicleLicense)
                .country(country)
                .userRole(userRole)
                .cv(cv)
                .qualifications(qualification)
                .experiences(experience).build();
    }

    /**
     * This method is intended for use only when a user is built upon
     * registration or singing up.
     * @param primaryEmail
     * @param password
     * */
    public static Graduate build(String userId, String primaryEmail, String password, String userRole) throws IllegalArgumentException
    {
        Utility.checkStringParam("userId", userId);
        Utility.checkStringParam("primaryEmail", primaryEmail);
        Utility.checkStringParam("password", password);

        return Graduate.builder().userId(userId)
                .email(primaryEmail).password(password)
                .userRole(userRole).build();
    }
}