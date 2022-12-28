package za.ac.cput.factory;


import za.ac.cput.model.Experience;
import za.ac.cput.model.Graduate;
import za.ac.cput.utility.Utility;

public class ExperienceFactory {
    public static Experience build(String jobTitle, String assumedRole, String startDate, String endDate, Graduate graduate) {
        Utility.checkStringParam("jobTitle", jobTitle);
        Utility.checkStringParam("assumedRole", assumedRole);
        Utility.checkStringParam("startDate", startDate);
        Utility.checkStringParam("endDate", endDate);

        return Experience.builder()
                .jobTitle(jobTitle)
                .assumedRole(assumedRole)
                .startDate(startDate)
                .endDate(endDate)
                .graduate(graduate)
                .build();
    }
}
