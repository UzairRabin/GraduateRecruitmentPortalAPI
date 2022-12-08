package za.ac.cput.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
public class Recruiter extends User{
    @Id
    private Long recruiterId;
    private String recruiterName;
    private String companyName;
    private String contactNumber;
    private LocalDate dateAdded;
}
