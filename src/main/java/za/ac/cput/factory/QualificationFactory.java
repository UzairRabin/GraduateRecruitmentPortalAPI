package za.ac.cput.factory;


import za.ac.cput.model.Qualification;
import za.ac.cput.utility.Utility;

public class QualificationFactory {
    public static Qualification build(String qualificationId, String qualificationName, String qualificationDescription){
        Utility.checkStringParam("qualificationId",qualificationName);
        Utility.checkStringParam("qualificationName", qualificationName);
        Utility.checkStringParam("qualificationDescription", qualificationDescription);

        return new Qualification.Builder().qualificationId(qualificationId).qualificationName(qualificationName).qualificationDescription(qualificationDescription).build();
    }
}
