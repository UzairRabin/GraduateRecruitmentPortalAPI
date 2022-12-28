package za.ac.cput.model;

import lombok.*;


/**
 * @author Mbuso Kotobe
 * */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSession {
    String sessionToken;
    Long userId;
}
