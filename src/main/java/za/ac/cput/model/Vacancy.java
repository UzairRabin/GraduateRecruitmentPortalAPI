package za.ac.cput.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Mbuso Kotobe
 * */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vacancyId;
    private String vacancyTitle;
    private String jobType;
    private String jobRole;
    private boolean isApproved;
    private String location;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Recruiter recruiter;
}
