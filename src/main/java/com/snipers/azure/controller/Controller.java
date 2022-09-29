package com.snipers.azure.controller;

import com.azure.communication.email.EmailClient;
import com.azure.communication.email.EmailClientBuilder;
import com.azure.communication.email.models.*;
import com.snipers.azure.beans.ChildRegistration;
import com.snipers.azure.beans.LoginCredentials;
import com.snipers.azure.beans.ReferSchool;
import com.snipers.azure.beans.RegistrationBean;
import com.snipers.azure.mapper.EntityMapper;
import com.snipers.azure.model.Child_Registration;
import com.snipers.azure.model.Login_Credentials;
import com.snipers.azure.model.Registration_Master;
import com.snipers.azure.model.School_Refer;
import com.snipers.azure.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static com.snipers.azure.utils.CommonUtils.uniqueId;

@RestController
public class Controller {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private SchoolReferRepository schoolReferRepository;

    @Autowired
    private ChildRegistrationRepository childRegistrationRepository;

    @Autowired
    private SchoolRegistrationRepository schoolRegistrationRepository;

    @Autowired
    private SignUpRepository signUpRepository;

    @Autowired
    private EntityMapper entityMapper;
    
    @CrossOrigin
    @PostMapping("/registration")
    public Registration_Master registrationMaster(@RequestBody RegistrationBean registrationBean) {
        Registration_Master registration_master = new Registration_Master();
        registration_master.setRegistrationId(uniqueId());
        registration_master.setRegistrationDate(registrationBean.getRegistrationDate());
        registration_master.setRegistrationStatus(registrationBean.getRegistrationStatus());
        registration_master.setRegistrationType(registrationBean.getRegistrationType());
        registration_master.setUserId(registrationBean.getUserId());
        return registrationRepository.save(registration_master);
    }
    @CrossOrigin
    @PostMapping("/login")
    public LoginCredentials login(@RequestBody LoginCredentials loginCredentailsBean) {
        LoginCredentials credentailsResponse = new LoginCredentials();
        Login_Credentials credentails = loginRepository.findById(loginCredentailsBean.getUserId()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Base64.Encoder encoder = Base64.getEncoder();
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encodeToString(loginCredentailsBean.getPassword().getBytes(StandardCharsets.UTF_8));
        //boolean matches = encodedPassword.matches(encodedPassword, credentails.getUserPassword());
        if (!encodedPassword.equals(credentails.getUserPassword()) && !loginCredentailsBean.getUserType().equalsIgnoreCase(credentails.getUserType())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passwords don't match or Usertype don't match");
        else {
            credentailsResponse.setUserId(credentails.getUserId());
            credentailsResponse.setUserType(credentails.getUserType());
        }
        return credentailsResponse;
    }
    @CrossOrigin
    @PostMapping("/referSchool")
    public String referSchool(@RequestBody ReferSchool referSchool){
        School_Refer school_refer = entityMapper.mapToSchoolReferEntity(referSchool);

        school_refer.setReferralId(uniqueId());
        sendMail(school_refer);
        schoolReferRepository.save(school_refer);
        return "Thanks for registering with us....ReferalId :" + school_refer.getReferralId();
    }
    @CrossOrigin
    @PostMapping("/childRegistration")
    public String childRegistration(@RequestBody ChildRegistration childRegistration){
        Child_Registration child_registration = new Child_Registration();
        child_registration.setChildId(uniqueId());
        child_registration.setUserId(childRegistration.getUserId());
        child_registration.setEmail(childRegistration.getEmail());
        child_registration.setFirstName(childRegistration.getFirstName());
        child_registration.setMiddleName(childRegistration.getMiddleName());
        child_registration.setLastName(childRegistration.getLastName());
        child_registration.setGender(childRegistration.getGender());
        child_registration.setPhone(childRegistration.getPhone());
        child_registration.setTypeOfHelp(childRegistration.getTypeOfHelp());
        childRegistrationRepository.save(child_registration);
        return "child registered successFully";
    }

    private void sendMail(School_Refer referSchool){
        String connectionString = "endpoint=https://codefest-communication-service.communication.azure.com/;accesskey=uNhIrqaD/ukokOcZBhuTNezDYey8vpa+N8PvXX7qhhH5pZVX1PUwJIxwH32UOLoXhmuAjayfhIndgMmOIZuVWw==";

        EmailClient emailClient = new EmailClientBuilder().connectionString(connectionString).buildClient();

        String subject = "Send email quick start - java";

        EmailContent emailContent = new EmailContent(subject)
                .setPlainText("This is plain mail send test body \n Best Wishes!!")
                .setHtml("<html><body><h1>Congrats on being referred</h1><br/><h2>City</h2><h4>Here is your referral Id ::    </h4><p>Happy Learning!!</p></body></html>");

        String sender = "StartYoungUK@69590e86-4355-459f-88ee-475db743e7bc.azurecomm.net";
        List<EmailAddress> emailAddress = new ArrayList<EmailAddress>() {
            {
                add(new EmailAddress(referSchool.getSchoolEmail()).setDisplayName("Deeven Successfully"));
                add(new EmailAddress(referSchool.getEmail()));
            }
        };

        EmailRecipients emailRecipients = new EmailRecipients(emailAddress);

        EmailMessage emailMessage = new EmailMessage(sender, emailContent)
                .setRecipients(emailRecipients);

        try
        {
            SendEmailResult sendEmailResult = emailClient.send(emailMessage);

            String messageId = sendEmailResult.getMessageId();
            if (!messageId.isEmpty() && messageId != null)
            {
                System.out.printf("Email sent, MessageId = {%s} %n", messageId);
            }
            else
            {
                System.out.println("Failed to send email.");
            }

            long waitTime = 120*1000;
            boolean timeout = true;
            while (waitTime > 0)
            {
                SendStatusResult sendStatus = emailClient.getSendStatus(messageId);
                System.out.printf("Send mail status for MessageId : <{%s}>, Status: [{%s}]", messageId, sendStatus.getStatus());

                if (!sendStatus.getStatus().toString().toLowerCase().equals(SendStatus.QUEUED.toString()))
                {
                    timeout = false;
                    break;
                }
                Thread.sleep(10000);
                waitTime = waitTime-10000;
            }

            if(timeout)
            {
                System.out.println("Looks like we timed out for email");
            }
        }
        catch (Exception ex)
        {
            System.out.printf("Error in sending email, {%s}", ex);
        }

    }
}
