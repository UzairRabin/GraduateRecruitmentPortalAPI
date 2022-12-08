package za.ac.cput.model;

/*
   User.java
   Damone Hartnick
 */

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public abstract class User implements Serializable {
    protected String email;
    protected String password;
    protected String userRole;
}
