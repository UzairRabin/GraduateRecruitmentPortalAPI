package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;

import za.ac.cput.model.Qualification;
import za.ac.cput.repository.IQualificationRepository;

import java.util.List;
import java.util.Optional;

public class QualificationServiceImpI implements IQualificationService{
    private IQualificationRepository repository;

    @Autowired
    public QualificationServiceImpI(IQualificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Qualification save(Qualification qualification) {
        return this.repository.save(qualification);
    }

    @Override
    public Optional<Qualification> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Qualification qualification) {
        this.repository.delete(qualification);
    }

    @Override
    public List<Qualification> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {

    }
}
