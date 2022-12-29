package za.ac.cput.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Chuma Nxazonke

 * Date: 24 November 2022
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Entity
public class Graduate extends User implements Serializable {

    @NotNull
    private String preferredName;

    @NotNull
    private String secondaryEmail;

    @JoinColumn(name = "cvId")
    @OneToOne
    private Cv cv;

    @OneToMany(mappedBy = "graduate", cascade = CascadeType.ALL)
    private Set<Qualification> qualifications;

    @OneToMany(mappedBy = "graduate", cascade = CascadeType.ALL)
    private Set<Experience> experiences;
}