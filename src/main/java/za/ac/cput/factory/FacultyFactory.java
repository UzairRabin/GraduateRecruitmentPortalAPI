package za.ac.cput.factory;

import za.ac.cput.model.Faculty;
import za.ac.cput.utility.Utility;

/**
 * @author Mbuso Kotobe
 * */
public class FacultyFactory {
    public static Faculty build(String facultyId, String facultyName, String facultyDescription)
    {
        Utility.checkStringParam("facultyId", facultyId);
        Utility.checkStringParam("facultyName", facultyName);
        Utility.checkStringParam("facultyDescription", facultyDescription);
        return Faculty.builder().facultyName(facultyName)
                                .facultyDescription(facultyDescription)
                                .build();
    }
}
