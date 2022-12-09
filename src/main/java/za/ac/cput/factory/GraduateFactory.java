package za.ac.cput.factory;


import jdk.jshell.execution.Util;
import lombok.experimental.Helper;
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

    public static Graduate createGraduateFactory ( String graduateId, String firstName, String preferredName, String surname, String primaryEmail, String secondaryEmail, String password, String cellphone, Experience experience, Qualification qualification, Cv cv){

        if(Utility.isEmptyOrNull(firstName) || Utility.isEmptyOrNull(preferredName) || Utility.isEmptyOrNull(surname) || Utility.isEmptyOrNull(primaryEmail) || Utility.isEmptyOrNull(secondaryEmail) || Utility.isEmptyOrNull(password) || Utility.isEmptyOrNull(cellphone))
            return null;
       Utility.checkStringParam("graduateId", String.valueOf(graduateId));

        Graduate graduate = new Graduate.Builder().setGraduateId(graduateId)
                .setQualification(qualification)
                .setExperience(experience)
                .setCV(cv)
                .setFirstName(firstName)
                .setPreferredName(preferredName).setSurname(surname)
                .setPrimaryEmail(primaryEmail).setSecondaryEmail(secondaryEmail)
                .setPassword(password).setCellphone(cellphone).build();

        return graduate;



    }
}