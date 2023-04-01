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
public class JobRequirement {
    @Id
    private String jobRequirementId;
    private String requirement;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Vacancy vacancy;
}
