package za.ac.cput.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    private String vacancyId;
    private String vacancyTitle;
    private String jobType;
    private String jobRole;
    private boolean isApproved;
    private String location;
    @Column(length = 1024)
    private String jobDescription;
    @Column(length = 1024)
    private String aboutCompany;
    @OneToMany(mappedBy = "vacancy" , cascade = CascadeType.ALL )
    private Set<JobResponsibility> jobResponsibilities;
    @OneToMany(mappedBy = "vacancy" , cascade = CascadeType.ALL )
    private Set<JobRequirement> jobRequirements;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Recruiter recruiter;
}
