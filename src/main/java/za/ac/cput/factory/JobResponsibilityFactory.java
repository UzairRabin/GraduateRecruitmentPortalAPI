package za.ac.cput.factory;

import za.ac.cput.model.JobResponsibility;
import za.ac.cput.model.Vacancy;

public class JobResponsibilityFactory {
    public static JobResponsibility build(String jobResponsibilityId, String responsibility, Vacancy vacancy)
    {
        return JobResponsibility.builder()
               .jobResponsibilityId(jobResponsibilityId)
               .responsibility(responsibility)
               .vacancy(vacancy).build();
    }
}
