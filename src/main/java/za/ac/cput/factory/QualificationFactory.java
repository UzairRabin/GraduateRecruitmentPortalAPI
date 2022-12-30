package za.ac.cput.factory;


import za.ac.cput.model.Graduate;
import za.ac.cput.model.Qualification;
import za.ac.cput.utility.Utility;

public class QualificationFactory {
    public static Qualification build(String qualificationName, String qualificationDescription, Graduate graduate){
        Utility.checkStringParam("qualificationName", qualificationName);
        Utility.checkStringParam("qualificationDescription", qualificationDescription);

        return Qualification.builder()
                            .qualificationName(qualificationName)
                            .qualificationDescription(qualificationDescription)
                            .graduate(graduate)
                            .build();
    }
}