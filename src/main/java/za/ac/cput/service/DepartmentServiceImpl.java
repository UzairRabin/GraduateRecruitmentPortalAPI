package za.ac.cput.service;
/*
 * @author Chadrack Mbuyi
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.model.Department;
import za.ac.cput.repository.IDepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService{

    private IDepartmentRepository repository;

    @Autowired
    public DepartmentServiceImpl(IDepartmentRepository repository){

        this.repository = repository;
    }

    @Override
    public Department save(Department department) {
        return this.repository.save(department);
    }

    @Override
    public Optional<Department> read(Integer integer) {
        return this.repository.findById(integer);
    }

    @Override
    public List<Department> findAll()
    {
        return repository.findAll();
    }

    @Override
    public void delete(Department department) {
        this.repository.delete(department);
    }

    @Override
    public List<Department> getAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(int departmentId) {

    }
}
