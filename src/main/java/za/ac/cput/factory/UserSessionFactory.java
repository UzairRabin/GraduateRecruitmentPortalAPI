package za.ac.cput.factory;

import za.ac.cput.model.UserSession;
import za.ac.cput.serviceFacade.UserAuthenticatorServiceFacadeImpl;

public class UserSessionFactory {
    public static UserSession build(String sessionToken, Long userId)
    {
        return UserSession.builder().sessionToken(sessionToken).userId(userId).build();
    }
}
