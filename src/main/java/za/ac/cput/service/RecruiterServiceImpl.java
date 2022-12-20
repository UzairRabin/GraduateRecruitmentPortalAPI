package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.factory.RecruiterFactory;
import za.ac.cput.model.Recruiter;
import za.ac.cput.repository.IRecruiterRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RecruiterServiceImpl implements IRecruiterService{

    IRecruiterRepository recruiterRepository;
    Recruiter safeRecruiter;

    @Autowired
    public RecruiterServiceImpl(IRecruiterRepository recruiterService){this.recruiterRepository = recruiterService;}

    @Override
    public Recruiter save(Recruiter recruiter) {
        try {
            safeRecruiter = RecruiterFactory.build(recruiter.getRecruiterId(),
                    recruiter.getFirstName(), recruiter.getCompanyName(),
                    recruiter.getCellphone(), recruiter.getDateAdded());
        }
        catch (IllegalArgumentException /*| IOException*/ exception)
        {
            log.error("Recruiter Service: Save Recruiter:{}", exception);
        }
        return recruiterRepository.save(safeRecruiter);
        }
        @Override
        public Optional<Recruiter> read(Long integer){return recruiterRepository.findById(integer);}

        @Override
        public List<Recruiter> findAll(){return this.recruiterRepository.findAll();}

        @Override
        public void delete(Recruiter recruiter){this.delete(recruiter);}

        @Override
        public void deleteById(Long recruiterId){recruiterRepository.deleteById(recruiterId);}
    }
