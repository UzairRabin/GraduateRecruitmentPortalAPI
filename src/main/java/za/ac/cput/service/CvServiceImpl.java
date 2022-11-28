/*
Author: Tiffany Kiwiets
Service class for CV
 */
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.model.Cv;
import za.ac.cput.repository.ICvRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CvServiceImpl implements ICvService {

    private ICvRepository repository;

    @Autowired
    public CvServiceImpl(ICvRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cv save(Cv cv) {
        return this.repository.save(cv);
    }

    @Override
    public Optional<Cv> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Cv cv) {
        this.repository.delete(cv);
    }

    @Override
    public List<Cv> findAll() {
        return this.repository.findAll();
    }

}
