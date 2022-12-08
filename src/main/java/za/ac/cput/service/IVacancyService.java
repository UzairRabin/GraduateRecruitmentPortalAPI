package za.ac.cput.service;

import za.ac.cput.model.Vacancy;

public interface IVacancyService extends IService<Vacancy, Long>{
    void deleteById(Long vacancyId);
}
