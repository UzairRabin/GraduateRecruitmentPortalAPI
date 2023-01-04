package za.ac.cput.service;

import za.ac.cput.model.Department;

import java.util.List;

public interface IDepartmentService extends IService<Department, String>{

    List<Department> getAll();

    void deleteById(String departmentId);

}
