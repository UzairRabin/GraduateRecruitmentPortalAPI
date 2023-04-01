package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.factory.JobRequirementFactory;
import za.ac.cput.factory.JobResponsibilityFactory;
import za.ac.cput.factory.VacancyFactory;
import za.ac.cput.model.JobRequirement;
import za.ac.cput.model.JobResponsibility;
import za.ac.cput.model.Recruiter;
import za.ac.cput.model.Vacancy;
import za.ac.cput.repository.IRecruiterRepository;
import za.ac.cput.repository.IVacancyRepository;
import za.ac.cput.utility.Utility;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Mbuso Kotobe
 *
 * */
@Slf4j
@Service
public class VacancyServiceImpl implements IVacancyService {

    IVacancyRepository vacancyRepository;
    IRecruiterRepository recruiterRepository;
    Vacancy safeVacancy;
    Optional<Recruiter> persistedRecruiter;
    String id = Utility.generateId();

    @Autowired
    public VacancyServiceImpl(IVacancyRepository vacancyService,
                              IRecruiterRepository recruiterRepository)
    {
        this.vacancyRepository = vacancyService;
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    public Vacancy save(Vacancy object) throws IllegalArgumentException
    {

        persistedRecruiter = recruiterRepository.findByEmail(object.getRecruiter().getEmail());
        persistedRecruiter.ifPresentOrElse(recruiter -> safeVacancy =
                        VacancyFactory.build(id,
                                object.getVacancyTitle(),
                                object.getJobType(),
                                object.getJobRole(),
                                object.isApproved(),
                                object.getLocation(),
                                object.getJobDescription(),
                                object.getAboutCompany(),
                                assignJobResponsibilityId(object.getJobResponsibilities()),
                                assignJobRequirementId(object.getJobRequirements()),
                                recruiter),

                () -> safeVacancy = VacancyFactory.build(id,
                        object.getVacancyTitle(), object.getJobType(),
                        object.getJobRole(), object.isApproved(),
                        object.getLocation(), object.getJobDescription(),
                        object.getAboutCompany(),
                        assignJobResponsibilityId(object.getJobResponsibilities()),
                        assignJobRequirementId(object.getJobRequirements()),
                        object.getRecruiter()));
        return vacancyRepository.save(safeVacancy);
    }

    @Override
    public Optional<Vacancy> read(String integer)
    {
        return vacancyRepository.findById(integer);
    }

    @Override
    public List<Vacancy> findAll()
    {
        return vacancyRepository.findAll();
    }

    @Override
    public void delete(Vacancy object)
    {
        vacancyRepository.delete(object);
    }

    @Override
    public void deleteById(String vacancyId)
    {
        vacancyRepository.deleteById(vacancyId);
    }

    private Set<JobResponsibility> assignJobResponsibilityId(Set<JobResponsibility> jobResponsibilities)
    {
        Set<JobResponsibility> responsibilitySet = new HashSet<>();
        jobResponsibilities.forEach(responsibility -> {
            responsibilitySet.add(
                JobResponsibilityFactory.build(Utility.generateId(),
                        responsibility.getResponsibility(),
                        responsibility.getVacancy())
            );
        });
        return responsibilitySet;
    }

    private Set<JobRequirement> assignJobRequirementId(Set<JobRequirement> jobResponsibilities)
    {
        Set<JobRequirement> requirementSet = new HashSet<>();
        jobResponsibilities.forEach(requirement -> {
            requirementSet.add(
                    JobRequirementFactory.build(Utility.generateId(),
                    requirement.getRequirement(),
                    requirement.getVacancy()));
        });
        return requirementSet;
    }
}
