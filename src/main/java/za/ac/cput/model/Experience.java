package za.ac.cput.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Experience {
    @Id
    private String experienceId;
    private String  jobTitle;
    private String assumedRole;
    private String startDate;
    private String endDate;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    Graduate graduate;

}