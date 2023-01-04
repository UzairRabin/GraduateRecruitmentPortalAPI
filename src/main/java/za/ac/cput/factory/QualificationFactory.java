package za.ac.cput.factory;


import za.ac.cput.model.Graduate;
import za.ac.cput.model.Qualification;
import za.ac.cput.utility.Utility;

public class QualificationFactory {
    public static Qualification build(String qualificationId, String qualificationName, String qualificationDescription, Graduate graduate){
        Utility.checkStringParam("qualificationId", qualificationId);
        Utility.checkStringParam("qualificationName", qualificationName);
        Utility.checkStringParam("qualificationDescription", qualificationDescription);

        return Qualification.builder()
                            .qualificationId(qualificationId)
                            .qualificationName(qualificationName)
                            .qualificationDescription(qualificationDescription)
                            .graduate(graduate)
                            .build();
    }
}