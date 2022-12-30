package za.ac.cput.service;

import za.ac.cput.model.Recruiter;

import java.util.Optional;

/**
 * @author Mbuso Kotobe
 *
 * */
public interface IRecruiterService extends IService<Recruiter, Long> {
    Optional<Recruiter> findRecruiterByEmail(String email);
    void deleteById(Long recruiterId);
    Recruiter signup(Recruiter recruiter);
}
