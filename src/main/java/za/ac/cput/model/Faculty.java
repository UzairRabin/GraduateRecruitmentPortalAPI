package za.ac.cput.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Mbuso Kotobe
 * */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Faculty {
    @Id
    private String facultyId;

    private String facultyName;

    private String facultyDescription;

    @OneToMany/*(mappedBy = "faculty")*/
    private Set<Department> departments;
}
