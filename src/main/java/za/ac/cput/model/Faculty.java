package za.ac.cput.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facultyId;

    private String facultyName;

    private String facultyDescription;

    @OneToMany(mappedBy = "faculty")
    private Set<Department> departments;
}
