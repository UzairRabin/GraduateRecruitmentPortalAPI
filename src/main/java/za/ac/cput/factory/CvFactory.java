/*
Author: Tiffany Kiwiets
Factory for CV
 */

package za.ac.cput.factory;

import za.ac.cput.model.Cv;
import za.ac.cput.utility.Utility;

import java.time.LocalDate;

public class CvFactory {
    public static Cv build(int cvId, String documentLocation, boolean isAcknowledged, LocalDate dateAdded) {
        Utility.checkStringParam("cvID", String.valueOf(cvId));
        Utility.checkStringParam("documentLocation", documentLocation);
        Utility.checkStringParam("isAcknowledged", String.valueOf(isAcknowledged));
        Utility.checkStringParam("dateAdded", String.valueOf(dateAdded));

        return new Cv.Builder().setCvId(cvId)
                .setDocumentLocation(documentLocation)
                .setAcknowledged(isAcknowledged)
                .setDateAdded(dateAdded)
                .build();
    }
}


