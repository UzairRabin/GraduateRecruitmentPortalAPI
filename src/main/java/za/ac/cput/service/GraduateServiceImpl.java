package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.model.Graduate;
import za.ac.cput.repository.IGraduateRepository;


import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 25 November 2022
 */
@Service
public class GraduateServiceImpl {

    private final IGraduateRepository repository;

    @Autowired
    public GraduateServiceImpl(IGraduateRepository repository){
        this.repository = repository;
    }

    //Save graduate details
    public Graduate saveGraduate (Graduate graduate){
        return this.repository.save(graduate);
    }


    //Read method
    public Graduate readGraduate(String graduateId) {
        return this.repository.findById(graduateId).orElse(null);
    }

    //Don't forget to include update method here
    public  Graduate updateGraduate(Graduate graduate){
        Graduate existingGraduate = repository.findById(graduate.getGraduateId()).orElse(null);
        existingGraduate.setFirstName(graduate.getFirstName());
        existingGraduate.setPreferredName(graduate.getPreferredName());
        existingGraduate.setSurname(graduate.getSurname());
        existingGraduate.setEmail(graduate.getEmail());
        existingGraduate.setSecondaryEmail(graduate.getSecondaryEmail());
        existingGraduate.setPassword(graduate.getPassword());
        existingGraduate.setCellphone(graduate.getCellphone());

        return this.repository.save(existingGraduate);
    }

    //Delete method
    public boolean deleteGraduate(String graduateId) {
        if(this.repository.existsById(graduateId)){
            this.repository.deleteById(graduateId);
            return true;
        }
        return false;
    }

    //Get All method
    public Set<Graduate> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

}

