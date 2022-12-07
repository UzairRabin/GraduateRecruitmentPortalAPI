package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.GraduateRecruitmentPortalAPI;
import za.ac.cput.factory.VacancyFactory;
import za.ac.cput.model.Vacancy;
import za.ac.cput.repository.IVacancyRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VacancyServiceImpl implements IVacancyService {

    IVacancyRepository vacancyRepository;
    Vacancy safeVacancy;

    @Autowired
    public VacancyServiceImpl(IVacancyRepository vacancyService)
    {
        this.vacancyRepository = vacancyService;
    }

    @Override
    public Vacancy save(Vacancy vacancy)
    {
        try{
            safeVacancy = VacancyFactory.build(
                    vacancy.getVacancyId(),
                    vacancy.getVacancyTitle(),
                    vacancy.getJobType(),
                    vacancy.getJobRole(),
                    vacancy.isApproved(),
                    vacancy.getLocation(),
                    vacancy.getRecruiter());


            //TODO Log events to file.
            //Create dir
            //Create file
            //Open file
            //Write error to file

//            File logDirPath = new File(GraduateRecruitmentPortalAPI.getAppDirectory() + "Logs" + "//");
//            if(!logDirPath.exists())
//            {
//                if(logDirPath.mkdirs())
//                {
//                    File logFile = new File(logDirPath.getAbsolutePath() + "Vacancy Service Log.log");
//                    FileWriter logWriter = new FileWriter(logFile, true);
//                }
//            }
        }catch (IllegalArgumentException /*| IOException*/ exception)
        {
            log.error("Vacancy Service: Save Vacancy:{}", exception);
        }
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
