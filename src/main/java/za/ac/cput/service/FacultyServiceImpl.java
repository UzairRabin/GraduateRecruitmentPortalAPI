package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.factory.FacultyFactory;
import za.ac.cput.model.Faculty;
import za.ac.cput.model.Recruiter;
import za.ac.cput.model.Faculty;
import za.ac.cput.repository.IRecruiterRepository;
import za.ac.cput.repository.IFacultyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements IFacultyService{
    IFacultyRepository facultyRepository;
    Faculty safeFaculty;
    Optional<Recruiter> persistedRecruiter;

    @Autowired
    public FacultyServiceImpl(IFacultyRepository facultyService)
    {
        this.facultyRepository = facultyService;
    }

    @Override
    public Faculty save(Faculty faculty) throws IllegalArgumentException
    {
        safeFaculty = FacultyFactory.build(faculty.getFacultyName(),
                                           faculty.getFacultyDescription());

        return this.facultyRepository.save(faculty);
    }

    @Override
    public Optional<Faculty> read(Long facultyId)
    {
        return this.facultyRepository.findById(facultyId);
    }

    @Override
    public List<Faculty> findAll()
    {
        return this.facultyRepository.findAll();
    }

    @Override
    public void delete(Faculty faculty)
    {
        this.facultyRepository.delete(faculty);
    }

    @Override
    public void deleteById(Long facultyId)
    {
        this.facultyRepository.deleteById(facultyId);
    }
}
