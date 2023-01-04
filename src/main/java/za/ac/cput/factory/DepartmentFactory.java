package za.ac.cput.factory;

import za.ac.cput.model.Department;
import za.ac.cput.model.Faculty;
import za.ac.cput.utility.Utility;

public class DepartmentFactory {
    public static Department build(String departmentId, String departmentName, Faculty faculty){
        Utility.checkStringParam("departmentId", departmentId);
        Utility.checkStringParam("departmentName", departmentName);

        return Department.builder().departmentId(departmentId)
                .departmentName(departmentName)
                .faculty(faculty)
                .build();
    }
}
