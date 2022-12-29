package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.factory.ExperienceFactory;
import za.ac.cput.model.Experience;
import za.ac.cput.repository.IExperienceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServiceImpl implements IExperienceService {
    private IExperienceRepository repository;

    @Autowired
    public ExperienceServiceImpl(IExperienceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Experience save(Experience experience) throws IllegalArgumentException
    {
        Experience newExperience = ExperienceFactory.build(experience.getJobTitle(),
                experience.getAssumedRole(),
                experience.getStartDate(),
                experience.getEndDate(),
                experience.getGraduate());
        return this.repository.save(newExperience);
    }

    @Override
    public Optional<Experience> read(Long ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(Experience object) {
        this.repository.delete(object);
    }

    @Override
    public void deleteById(Long Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public List<Experience> findAll() {
        return this.repository.findAll();
    }

}
