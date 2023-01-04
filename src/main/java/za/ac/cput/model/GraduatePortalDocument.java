package za.ac.cput.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Entity
public class GraduatePortalDocument {
    @Id
    private String documentId;
    private String documentName;
    private String documentType;
    private String documentLocation;
    private byte[] documentData;
    private LocalDate dateAdded;
}
