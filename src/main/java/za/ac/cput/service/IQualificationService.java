package za.ac.cput.service;

import za.ac.cput.model.Qualification;

public interface IQualificationService extends IService <Qualification, String> {
    void deleteById(String id);
}
