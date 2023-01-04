package za.ac.cput.model;

/*
   User.java
   Damone Hartnick
 */

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Mbuso Kotobe
 * */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder(toBuilder = true)
public abstract class User implements Serializable {
    @Id
    protected String userId;
    protected String firstName;
    protected String surname;
    protected String email;
    protected String password;
    protected String cellphone;
    protected String userRole;
}