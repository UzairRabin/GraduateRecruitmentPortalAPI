package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.model.Experience;
import za.ac.cput.repository.ExperienceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServiceImpl implements IExperienceService {
    private ExperienceRepository repository;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Experience save(Experience experience) {
        return this.repository.save(experience);
    }

    @Override
    public Optional<Experience> read(String ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(Experience experience) {
        this.repository.delete(experience);
    }

    @Override
    public void deleteById(String Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public List<Experience> findAll() {
        return this.repository.findAll();
    }

    public Optional<Experience> findExperienceByExperienceId(String experienceId) {
        return this.repository.findExperienceByExperienceId(experienceId);

    }
}
