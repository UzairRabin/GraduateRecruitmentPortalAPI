package za.ac.cput.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

/**
 * @author Chuma Nxazonke

 * Date: 24 November 2022
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Entity
public class Graduate extends User implements Serializable {

    //Declaring all the private fields for the program
    @Id
    @Column(name = "graduateId")
    private String graduateId;

    @JoinColumn(name = "experienceId")
    @OneToOne
    private Experience experiences;

    @JoinColumn(name = "cvId")
    @OneToOne
    private Cv cv;

    @JoinColumn(name = "qualificationId")
    @OneToOne
    private Qualification qualification;

    @NotNull
    private String preferredName;

    @NotNull
    private String secondaryEmail;

}
