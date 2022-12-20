package za.ac.cput.factory;

import za.ac.cput.model.Recruiter;
import za.ac.cput.utility.Utility;

import java.time.LocalDate;

public class RecruiterFactory {
    public static Recruiter build(Long recruiterId, String recruiterName, String companyName,
     String contactNumber,
     LocalDate dateAdded)
    {
        return Recruiter.builder().firstName(recruiterName).companyName(companyName)
                                  .cellphone(contactNumber).dateAdded(dateAdded)
                                  .build();
    }
}
