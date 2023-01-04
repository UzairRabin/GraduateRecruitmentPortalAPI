package za.ac.cput.service;

import za.ac.cput.model.Vacancy;

/**
 * @author Mbuso Kotobe
 *
 * */
public interface IVacancyService extends IService<Vacancy, String>{
    void deleteById(String vacancyId);
}
