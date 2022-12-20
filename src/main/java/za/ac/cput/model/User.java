package za.ac.cput.model;

/*
   User.java
   Damone Hartnick
 */

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
public abstract class User implements Serializable {
    protected String firstName;
    protected String surname;
    protected String email;
    protected String password;
    protected String cellphone;
    protected String userRole;
}
