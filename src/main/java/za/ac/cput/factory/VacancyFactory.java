package za.ac.cput.factory;

import za.ac.cput.model.Recruiter;
import za.ac.cput.model.Vacancy;
import za.ac.cput.utility.Utility;

import javax.persistence.ManyToOne;

/**
 * @author Mbuso Kotobe
 * */
public class VacancyFactory {

    public static Vacancy build(Long vacancyId, String vacancyTitle, String jobType,
                                String jobRole, boolean isApproved, String location,
                                Recruiter recruiter)
    {
        Utility.checkStringParam("vacancyTitle", vacancyTitle);
        Utility.checkStringParam("jobType", jobType);
        Utility.checkStringParam("jobRole", jobRole);
        Utility.checkStringParam("location", location);

        return Vacancy.builder().vacancyTitle(vacancyTitle).jobType(jobType)
                                .jobRole(jobRole).isApproved(isApproved)
                                .location(location).recruiter(recruiter)
                                .build();
    }
}
