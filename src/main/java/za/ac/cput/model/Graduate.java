package za.ac.cput.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Objects;
import java.io.Serializable;

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

    //Declaring all the private fields for the program
//    @Id
//    @Column(name = "graduateId")
//    private String graduateId;

    @NotNull
    private String preferredName;

    @NotNull
    private String secondaryEmail;

    @JoinColumn(name = "cvId")
    @OneToOne
    private Cv cv;

    @JoinColumn(name = "qualification")
    @OneToOne
    private Qualification qualification;

    @JoinColumn(name = "experienceId")
    @OneToOne
    private Experience experience;
}
