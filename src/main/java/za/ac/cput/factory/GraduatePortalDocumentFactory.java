package za.ac.cput.factory;

import za.ac.cput.model.Cv;
import za.ac.cput.model.GraduatePortalDocument;
import za.ac.cput.utility.Utility;

import java.time.LocalDate;

public class GraduatePortalDocumentFactory {
    public static GraduatePortalDocument build(String documentName,
                                               String documentType, String documentLocation,
                                               byte[] documentData, LocalDate dateAdded)
    {
        Utility.checkStringParam("documentName", documentName);
        Utility.checkStringParam("documentLocation", documentLocation);
        Utility.checkStringParam("documentType", documentType);
        Utility.checkStringParam("dateAdded", String.valueOf(dateAdded));

        return GraduatePortalDocument.builder().documentName(documentName)
                .documentLocation(documentLocation)
                .documentType(documentType)
                .documentData(documentData)
                .dateAdded(dateAdded)
                .build();
    }
}
