package com.snipers.azure.controller;

import com.azure.communication.email.EmailClient;
import com.azure.communication.email.EmailClientBuilder;
import com.azure.communication.email.models.*;
import com.snipers.azure.beans.*;
import com.snipers.azure.mapper.EntityMapper;
import com.snipers.azure.model.*;
import com.snipers.azure.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
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
        String subject = "Woooh you have been referred..!!!";
        schoolReferRepository.save(school_refer);
        EmailContent emailContent = new EmailContent(subject)
                .setPlainText("This is plain mail send test body\n Best Wishes!!")
                .setHtml("<html><body><h1>Looking forward to hear from you</h1><br/><p>click on the below to register with us</p><br/><a href=\"https://start-young-app.azurewebsites.net\">Visit Smart Youth Uk Registration Page</a></body></html>");
        List<EmailAddress> emailAddress = new ArrayList<EmailAddress>() {
            {
                add(new EmailAddress(referSchool.getSchoolEmail()));
            }
        };
        sendMail(emailAddress,emailContent);

        String subjectRef = "Thanks for your reference..!!!";
        EmailContent emailContentRef = new EmailContent(subjectRef)
                .setPlainText("This is plain mail send test body\n Best Wishes!!")
                .setHtml("<html><body><h1>Thanks for your valuable referral</h1><br/><p>more to goo.......</p></body></html>");
        List<EmailAddress> emailAddressRef = new ArrayList<EmailAddress>() {
            {
                add(new EmailAddress(referSchool.getEmail()));
            }
        };
        sendMail(emailAddressRef,emailContentRef);
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
        String subjectRef = "Thanks for your registration..!!!";
        EmailContent emailContentRef = new EmailContent(subjectRef)
                .setPlainText("This is plain mail send test body\n Best Wishes!!")
                .setHtml("<html><body><h1>Will get in touch soon</h1></body></html>");
        List<EmailAddress> emailAddressRef = new ArrayList<EmailAddress>() {
            {
                add(new EmailAddress(childRegistration.getEmail()));
            }
        };
        sendMail(emailAddressRef,emailContentRef);
        return "child registered successFully";
    }
    @CrossOrigin
    @PostMapping("/registerSchool")
    public String schoolRegistration(@RequestBody SchoolRegistration schoolRegistration) throws Exception {
        School_Registration school_registration = entityMapper.mapToSchoolRegistrationEntity(schoolRegistration);
        school_registration.setUserId(uniqueId());
        schoolRegistrationRepository.save(school_registration);
        String subjectRef = "Thanks for your registration..!!!";
        EmailContent emailContentRef = new EmailContent(subjectRef)
                .setPlainText("This is plain mail send test body\n Best Wishes!!")
                .setHtml("<html><body><h1>Welcome Onboard</h1></body></html>");
        List<EmailAddress> emailAddressRef = new ArrayList<EmailAddress>() {
            {
                add(new EmailAddress(schoolRegistration.getSchoolEmail()));
            }
        };
        sendMail(emailAddressRef,emailContentRef);
        return "Success";
    }

    @CrossOrigin
    @RequestMapping("/schoolList")
    public List<School_Registration> fetchReferredSchoolRecord(){
        List<School_Registration> schoolsList =  schoolRegistrationRepository.findAll();
        return schoolsList;
    }



    @CrossOrigin
    @PostMapping("/signUp")
    public String signUpFunction(@RequestBody SignUp signUp){
        Sign_Up sign_up = entityMapper.mapToSignUpEntity(signUp);
        sign_up.setRegistrationId(uniqueId());
        signUpRepository.save(sign_up);
        String subject = "Smart Youth Uk Welcomes You !!!";
        EmailContent emailContent = new EmailContent(subject)
                .setPlainText("This is plain mail send test body\n Best Wishes!!")
                .setHtml("<html><body><h1>Thanks for registering with us</h1><br/><p>Looking forward to work with you!!</p></body></html>");

        List<EmailAddress> emailAddress = new ArrayList<EmailAddress>() {
            {
                add(new EmailAddress(signUp.getEmail()));
            }
        };

        sendMail(emailAddress,emailContent);

        return "Success";
    }

    private void sendMail(List<EmailAddress> emailAddresses,EmailContent emailContent){
        String connectionString = "endpoint=https://codefest-communication-service.communication.azure.com/;accesskey=uNhIrqaD/ukokOcZBhuTNezDYey8vpa+N8PvXX7qhhH5pZVX1PUwJIxwH32UOLoXhmuAjayfhIndgMmOIZuVWw==";

        EmailClient emailClient = new EmailClientBuilder().connectionString(connectionString).buildClient();


        String sender = "StartYoungUK@69590e86-4355-459f-88ee-475db743e7bc.azurecomm.net";

        EmailRecipients emailRecipients = new EmailRecipients(emailAddresses);

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
