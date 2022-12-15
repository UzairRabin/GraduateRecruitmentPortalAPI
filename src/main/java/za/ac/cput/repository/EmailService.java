package za.ac.cput.repository;

import za.ac.cput.model.EmailDetails;

public interface EmailService {
    //This method can be used to send a simple text email to the desired recipient
    String sendSimpleMail(EmailDetails details);

    //This method can be used to send an email along with an attachment to the desired recipient
    String sendMailWithAttachment(EmailDetails details);

}
