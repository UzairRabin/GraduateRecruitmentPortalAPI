package za.ac.cput.factory;

import za.ac.cput.model.Department;
import za.ac.cput.model.Faculty;
import za.ac.cput.utility.Utility;

public class DepartmentFactory {
    public static Department build(String departmentName, Faculty faculty){
        Utility.checkStringParam("departmentName", departmentName);

        return Department.builder()
                .departmentName(departmentName)
                .faculty(faculty)
                .build();
    }
}
