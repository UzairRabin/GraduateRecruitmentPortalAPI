package za.ac.cput.service.experience;

import za.ac.cput.model.Experience;
import za.ac.cput.service.IService;

import java.util.List;

public interface ExperienceService extends IService<Experience, String> {
        void deleteById(String Id);
        List<Experience> findAll();
        }