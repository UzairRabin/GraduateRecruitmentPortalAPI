package za.ac.cput.service;

import za.ac.cput.model.Recruiter;

public interface IRecruiterService extends IService<Recruiter, Long> {
    void deleteById(Long recruiterId);
}
