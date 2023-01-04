package za.ac.cput.service;

import za.ac.cput.model.Experience;

import java.util.List;

public interface IExperienceService extends IService<Experience, String> {
    void deleteById(String Id);
}