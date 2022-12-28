package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.exception.NotRegisteredUserException;
import za.ac.cput.exception.PasswordMismatchException;
import za.ac.cput.factory.GraduateFactory;
import za.ac.cput.model.Graduate;
import za.ac.cput.repository.IGraduateRepository;
import za.ac.cput.serviceFacade.UserAuthenticatorServiceFacadeImpl;


import java.util.List;
import java.util.Optional;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 25 November 2022
 */
@Service
public class GraduateServiceImpl implements IGraduateService, IUserAuthenticatorService<Graduate>{

    private final IGraduateRepository repository;

    @Autowired
    public GraduateServiceImpl(IGraduateRepository repository){
        this.repository = repository;
    }

    public Graduate save(Graduate graduate) throws IllegalArgumentException
    {
       Graduate validatedGraduate = GraduateFactory.build(graduate.getFirstName(),
                graduate.getPreferredName(),
                graduate.getSurname(),
                graduate.getEmail(),
                graduate.getSecondaryEmail(),
                graduate.getPassword(),
                graduate.getCellphone(),
                graduate.getCv(),
                graduate.getQualification(),
                graduate.getExperience());

        return this.repository.save(validatedGraduate);
    }


    public Optional<Graduate> read(Long graduateId)
    {
        return this.repository.findById(graduateId);
    }

    public Optional<Graduate> findGraduateByEmail(String email)
    {
        return this.repository.findByEmail(email);
    }

    public void deleteById(Long graduateId)
    {
        this.repository.deleteById(graduateId);
    }

    public List<Graduate> findAll()
    {
        return this.repository.findAll();
    }

    public void delete(Graduate graduate)
    {
        this.repository.delete(graduate);
    }

    @Override
    public Graduate login(Graduate user) throws NotRegisteredUserException, PasswordMismatchException
    {
        Optional<Graduate> registeredUser = findGraduateByEmail(user.getEmail());
        return UserAuthenticatorServiceFacadeImpl.validateUserCredentials(
               registeredUser.isPresent(), user, registeredUser.get());
    }
}

