package za.ac.cput.factory;

import lombok.experimental.Helper;
import za.ac.cput.model.Qualification;

public class QualificationFactory {
    public static Qualification build(String qualificationId, String qualificationName, String qualificationDescription){
        Helper.checkStringParam("qualificationId",qualificationName)
        Helper.checkStringParam("qualificationName", qualificationName);
        Helper.checkStringParam("qualificationDescription", qualificationDescription);

        return new Qualification.Builder().qualificationId(qualificationId).qualificationName(qualificationName).qualificationDescription(qualificationDescription).build();
    }
}
