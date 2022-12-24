package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.factory.VacancyFactory;
import za.ac.cput.model.Recruiter;
import za.ac.cput.model.Vacancy;
import za.ac.cput.repository.IRecruiterRepository;
import za.ac.cput.repository.IVacancyRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VacancyServiceImpl implements IVacancyService {

    IVacancyRepository vacancyRepository;
    IRecruiterRepository recruiterRepository;
    Vacancy safeVacancy;
    Optional<Recruiter> persistedRecruiter;

    @Autowired
    public VacancyServiceImpl(IVacancyRepository vacancyService,
                              IRecruiterRepository recruiterRepository)
    {
        this.vacancyRepository = vacancyService;
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    public Vacancy save(Vacancy vacancy) throws IllegalArgumentException
    {
        persistedRecruiter = recruiterRepository.findByEmail(vacancy.getRecruiter().getEmail());
        persistedRecruiter.ifPresentOrElse(recruiter -> safeVacancy =
                        VacancyFactory.build(vacancy.getVacancyId(),
                                vacancy.getVacancyTitle(), vacancy.getJobType(),
                                vacancy.getJobRole(), vacancy.isApproved(),
                                vacancy.getLocation(), recruiter),

                () -> safeVacancy = VacancyFactory.build(vacancy.getVacancyId(),
                        vacancy.getVacancyTitle(), vacancy.getJobType(),
                        vacancy.getJobRole(), vacancy.isApproved(),
                        vacancy.getLocation(), vacancy.getRecruiter()));
        return vacancyRepository.save(safeVacancy);
    }

    @Override
    public Optional<Vacancy> read(Long integer)
    {
        return vacancyRepository.findById(integer);
    }

    @Override
    public List<Vacancy> findAll()
    {
        return vacancyRepository.findAll();
    }

    @Override
    public void delete(Vacancy vacancy)
    {
        vacancyRepository.delete(vacancy);
    }

    @Override
    public void deleteById(Long vacancyId)
    {
        vacancyRepository.deleteById(vacancyId);
    }
}
