package za.ac.cput.factory;

import za.ac.cput.model.JobRequirement;
import za.ac.cput.model.JobResponsibility;
import za.ac.cput.model.Recruiter;
import za.ac.cput.model.Vacancy;
import za.ac.cput.utility.Utility;

import javax.persistence.ManyToOne;
import java.util.Set;

/**
 * @author Mbuso Kotobe
 * */
public class VacancyFactory {

    public static Vacancy build(String vacancyId, String vacancyTitle, String jobType,
                                String jobRole, boolean isApproved, String location, String description,
                                String aboutCompany, Set<JobResponsibility> jobResponsibilities, Set<JobRequirement> jobRequirements, Recruiter recruiter)
    {
        Utility.checkStringParam("vacancyId", vacancyId);
        Utility.checkStringParam("vacancyTitle", vacancyTitle);
        Utility.checkStringParam("jobType", jobType);
        Utility.checkStringParam("jobRole", jobRole);
        Utility.checkStringParam("location", location);
        Utility.checkStringParam("jobDescription", description);
        Utility.checkStringParam("aboutCompany", aboutCompany);

        return Vacancy.builder().vacancyId(vacancyId).vacancyTitle(vacancyTitle).jobType(jobType)
                                .jobRole(jobRole).isApproved(isApproved)
                                .location(location).recruiter(recruiter)
                                .jobDescription(description).jobResponsibilities(jobResponsibilities)
                                .jobRequirements(jobRequirements).aboutCompany(aboutCompany)
                                .build();
    }

    public static Vacancy build(String vacanyId)
    {
        return Vacancy.builder().vacancyId(vacanyId).build();
    }
}
