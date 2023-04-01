package za.ac.cput.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class JobResponsibility {
    @Id
    private String jobResponsibilityId;
    private String responsibility;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Vacancy vacancy;
}
