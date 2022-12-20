package za.ac.cput.model;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Chadrack Mbuyi
 * */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Department implements Serializable {

    @Id
    @NotNull private int departmentId;
    @NotNull private String departmentName;
}
