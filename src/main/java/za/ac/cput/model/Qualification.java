package za.ac.cput.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Qualification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qualificationId;
    private String qualificationName;
    private String qualificationDescription;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Graduate graduate;
}
