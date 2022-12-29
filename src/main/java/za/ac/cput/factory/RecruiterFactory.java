package za.ac.cput.factory;

import za.ac.cput.model.Recruiter;
import za.ac.cput.model.Vacancy;
import za.ac.cput.utility.Utility;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author Mbuso Kotobe
 * */
public class RecruiterFactory {


    public static Recruiter build(String recruiterName, String surname, String companyName,
                                  String email, String contactNumber, String password,
                                  Set<Vacancy> vacancies, String userRole, LocalDate dateAdded)
    {
        Utility.checkStringParam("email", email);
        Utility.checkStringParam("password", password);
        Utility.checkStringParam("userRole", userRole);

        return Recruiter.builder().firstName(recruiterName).surname(surname)
                                  .email(email).companyName(companyName)
                                  .password(password).cellphone(contactNumber)
                                  .userRole("RECRUITER").vacancies(vacancies)
                                  .dateAdded(dateAdded)
                                  .build();
    }
}
