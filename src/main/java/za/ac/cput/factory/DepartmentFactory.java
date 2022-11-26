package za.ac.cput.factory;

import za.ac.cput.model.Department;
import za.ac.cput.utility.Utility;

public class DepartmentFactory {
    public static Department build(int departmentId, String departmentName){
        Utility.checkStringParam("departmentId", String.valueOf(departmentId));
        Utility.checkStringParam("departmentName", departmentName);

        return new Department.Builder().setDepartmentId(departmentId)
                .setDepartmentName(departmentName)
                .build();
    }
}
