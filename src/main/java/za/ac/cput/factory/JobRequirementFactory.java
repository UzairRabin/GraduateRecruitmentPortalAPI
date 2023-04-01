package za.ac.cput.factory;

import za.ac.cput.model.JobRequirement;
import za.ac.cput.model.Vacancy;

public class JobRequirementFactory {
    public static JobRequirement build(String jobRequirementId, String requirement, Vacancy vacancy)
    {
        return JobRequirement.builder()
                .jobRequirementId(jobRequirementId)
                .requirement(requirement)
                .vacancy(vacancy).build();
    }
}
