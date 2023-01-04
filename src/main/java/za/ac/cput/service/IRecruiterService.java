package za.ac.cput.service;

import za.ac.cput.model.Recruiter;

import java.util.Optional;

/**
 * @author Mbuso Kotobe
 *
 * */
public interface IRecruiterService extends IService<Recruiter, String> {
    Optional<Recruiter> findRecruiterByEmail(String email);
    void deleteById(String recruiterId);
    Recruiter signup(Recruiter recruiter);
}
