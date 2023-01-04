/*
Author: Tiffany Kiwiets
Factory for CV
 */

package za.ac.cput.factory;

import za.ac.cput.model.Cv;
import za.ac.cput.utility.Utility;

import java.time.LocalDate;

public class CvFactory {
    public static Cv build(String cvId, String documentName, String documentLocation, boolean isAcknowledged, LocalDate dateAdded) {
        Utility.checkStringParam("documentName", documentName);
        Utility.checkStringParam("documentLocation", documentLocation);
        Utility.checkStringParam("dateAdded", String.valueOf(dateAdded));

        return Cv.builder().cvId(cvId)
                .documentName(documentName)
                .documentLocation(documentLocation)
                .isAcknowledged(isAcknowledged)
                .dateAdded(dateAdded)
                .build();
    }
}


