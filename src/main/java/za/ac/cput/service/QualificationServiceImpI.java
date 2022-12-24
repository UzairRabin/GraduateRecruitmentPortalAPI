package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import za.ac.cput.factory.QualificationFactory;
import za.ac.cput.model.Qualification;
import za.ac.cput.repository.IQualificationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationServiceImpI implements IQualificationService{

    private IQualificationRepository repository;
    private Qualification validatedQualification;

    @Autowired
    public QualificationServiceImpI(IQualificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Qualification save(Qualification qualification)
    {
        validatedQualification = QualificationFactory.build(qualification.getQualificationId(),
                qualification.getQualificationName(),
                qualification.getQualificationDescription());

        return this.repository.save(validatedQualification);
    }

    @Override
    public Optional<Qualification> read(String s)
    {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Qualification qualification)
    {
        this.repository.delete(qualification);
    }

    @Override
    public List<Qualification> findAll()
    {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {

    }
}
