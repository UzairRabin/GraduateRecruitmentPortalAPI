//Implementing a Rest Controller
//Define various API for send Mail

package za.ac.cput.controller;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 */
// Importing required classes
import org.springframework.web.bind.annotation.CrossOrigin;
import za.ac.cput.model.EmailDetails;
import za.ac.cput.repository.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Annotation
@RestController
// Class
public class EmailController {

    @Autowired private EmailService emailService;

    // Sending a simple Email
    @PostMapping("/sendMail")
    @CrossOrigin(origins = "http://localhost:4200")
    public String sendMail(@RequestBody EmailDetails details)
    {
        String status = emailService.sendSimpleMail(details);

        return status;
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    @CrossOrigin(origins = "http://localhost:4200")
    public String sendMailWithAttachment(@RequestBody EmailDetails details)
    {
        String status = emailService.sendMailWithAttachment(details);

        return status;
    }
}
