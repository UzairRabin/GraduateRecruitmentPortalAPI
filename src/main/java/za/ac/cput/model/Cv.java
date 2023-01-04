/*
Author: Tiffany Kiwiets
Entity class for CV
 */

package za.ac.cput.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Cv implements Serializable {
    @Id
    @NotNull private String cvId;
    @NotNull private String documentName;
    @NotNull private String documentLocation;
    @NotNull private boolean isAcknowledged;
    private byte[] cvData;
    @NotNull private LocalDate dateAdded;
}
