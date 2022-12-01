package za.ac.cput.service;

import za.ac.cput.model.Vacancy;

public interface IVacancyService extends IService<Vacancy, Integer>{
    void deleteById(Integer vacancyId);
}
