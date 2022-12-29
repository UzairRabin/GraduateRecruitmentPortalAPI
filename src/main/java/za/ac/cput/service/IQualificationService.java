package za.ac.cput.service;

import za.ac.cput.model.Qualification;

import java.util.List;

public interface IQualificationService extends IService <Qualification, Long> {
    void deleteById(String id);
}
