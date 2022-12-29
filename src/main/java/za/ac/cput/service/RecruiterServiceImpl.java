package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.exception.NotRegisteredUserException;
import za.ac.cput.exception.PasswordMismatchException;
import za.ac.cput.factory.RecruiterFactory;
import za.ac.cput.model.Graduate;
import za.ac.cput.model.Recruiter;
import za.ac.cput.repository.IRecruiterRepository;
import za.ac.cput.serviceFacade.UserAuthenticatorServiceFacadeImpl;

import java.util.List;
import java.util.Optional;

/**
 * @author Mbuso Kotobe
 *
 * */
@Slf4j
@Service
public class RecruiterServiceImpl implements IRecruiterService, IUserAuthenticatorService<Recruiter> {

    IRecruiterRepository recruiterRepository;
    Recruiter safeRecruiter;

    @Autowired
    public RecruiterServiceImpl(IRecruiterRepository recruiterService)
    {
        this.recruiterRepository = recruiterService;
    }

    @Override
    public Recruiter save(Recruiter object) throws IllegalArgumentException
    {
        safeRecruiter = RecruiterFactory.build(object.getFirstName(),
                                               object.getSurname(),
                                               object.getCompanyName(),
                                               object.getEmail(),
                                               object.getCellphone(),
                                               object.getPassword(),
                                               object.getVacancies(),
                                               object.getUserRole(),
                                               object.getDateAdded());
        return recruiterRepository.save(safeRecruiter);
    }

    @Override
    public Optional<Recruiter> read(Long integer)
    {
        return recruiterRepository.findById(integer);
    }

    @Override
    public List<Recruiter> findAll()
    {
        return this.recruiterRepository.findAll();
    }

    @Override
    public void delete(Recruiter object)
    {
        this.delete(object);
    }


    @Override
    public Optional<Recruiter> findRecruiterByEmail(String email)
    {
        return recruiterRepository.findByEmail(email);
    }

    @Override
    public void deleteById(Long recruiterId)
    {
        recruiterRepository.deleteById(recruiterId);
    }

    @Override
    public Recruiter login(Recruiter user) throws NotRegisteredUserException, PasswordMismatchException
    {
        Optional<Recruiter> registeredUser = findRecruiterByEmail(user.getEmail());
        //Recruiter validatedUser
        return UserAuthenticatorServiceFacadeImpl.validateUserCredentials(
                registeredUser.isPresent(),
                user, registeredUser.get());
    }
}
