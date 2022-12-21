package za.ac.cput.factory;



import lombok.Setter;
import za.ac.cput.model.Cv;
import za.ac.cput.model.Experience;
import za.ac.cput.model.Graduate;
import za.ac.cput.model.Qualification;

import za.ac.cput.utility.Utility;


/**
 * @author Chuma Nxazonke
 * Date: 23 November 2022
 * */

public class GraduateFactory {

    public static Graduate createGraduateFactory (String graduateId, String firstName, String preferredName, String surname, String primaryEmail, String secondaryEmail, String password, String cellphone,Cv cv, Qualification qualification, Experience experience){

        Utility.checkStringParam("firstName", firstName);
        Utility.checkStringParam("preferredName", preferredName);
        Utility.checkStringParam("surname", surname);
        Utility.checkStringParam("primaryEmail", primaryEmail);
        Utility.checkStringParam("secondaryEmail", secondaryEmail);
        Utility.checkStringParam("password", password);
        Utility.checkStringParam("cellphone", cellphone);
        Utility.checkStringParam("graduateId", String.valueOf(graduateId));

        return new Graduate.Builder().setGraduateId(graduateId)
                .setFirstName(firstName)
                .setPreferredName(preferredName)
                .setSurname(surname)
                .setPrimaryEmail(primaryEmail)
                .setSecondaryEmail(secondaryEmail)
                .setPassword(password)
                .setCellphone(cellphone)
                .setCV(cv)
                .setQualification(qualification)
                .setExperience(experience).build();

    }
}