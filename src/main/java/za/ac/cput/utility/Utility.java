package za.ac.cput.utility;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Mbuso Kotobe
 *
 * Do not remove this class. This class will act as a helper class.
 * General methods that are convenient for everyone must be defined
 * and implemented here.
 *
 * Please keep all class member methods static.
 * */
public class Utility {

    public static void checkStringParam(String paramName, String paramValue) {
        if(isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(
                    String.format("Invalid value for params: %s", paramName)
            );
    }

    private static boolean isEmptyOrNull(String s) {
        return StringUtils.isEmpty(s);
    }
}
