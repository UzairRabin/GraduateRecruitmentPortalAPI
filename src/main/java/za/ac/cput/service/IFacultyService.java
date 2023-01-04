package za.ac.cput.service;

import za.ac.cput.model.Faculty;

/**
 * @author Mbuso Kotobe
 *
 * */
public interface IFacultyService extends IService<Faculty, String>{
    void deleteById(String facultyId);
}
