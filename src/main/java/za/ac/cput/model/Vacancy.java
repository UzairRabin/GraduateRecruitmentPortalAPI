package za.ac.cput.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Vacancy {
    @Id
    @GeneratedValue
    private Long vacancyId;
    private String vacancyTitle;
    private String jobType;
    private String jobRole;
    private boolean isApproved;
    private String location;
    @ManyToOne
    private Recruiter recruiter;
}
