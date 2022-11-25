package za.ac.cput.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Chadrack Mbuyi
 * */
@Entity
public class Department implements Serializable {

    @Id
    @NotNull private int departmentId;
    @NotNull private String departmentName;

    public Department() {

    }

    public Department(Builder builder) {
        this.departmentId = builder.departmentId;
        this.departmentName = builder.departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department that)) return false;
        return getDepartmentId() == that.getDepartmentId() && Objects.equals(getDepartmentName(), that.getDepartmentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartmentId(), getDepartmentName());
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public static class Builder{

        @NotNull private int departmentId;
        @NotNull private String departmentName;

        public Builder setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder copy(Department department){
            this.departmentId = department.departmentId;
            this.departmentName = department.departmentName;
            return this;
        }

        public Department build(){
            return new Department(this);
        }
    }
}
