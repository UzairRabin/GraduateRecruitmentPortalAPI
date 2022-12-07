package za.ac.cput.model;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public abstract class User {
    protected String email;
    protected String password;
    protected String userRole;
}
