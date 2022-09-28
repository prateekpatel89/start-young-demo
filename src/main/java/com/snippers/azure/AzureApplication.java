package com.snippers.azure;

import com.snippers.azure.beans.RegistrationBean;
import com.snippers.azure.model.Registration_Master;
import com.snippers.azure.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AzureApplication {

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping("/registartion")
    public Registration_Master registrationMaster(@RequestBody RegistrationBean registrationBean) {
        Registration_Master registration_master = new Registration_Master();
        registration_master.setRegistrationId(uniqueId());
        registration_master.setRegistrationDate(registrationBean.getRegistrationDate());
        registration_master.setRegistrationStatus(registrationBean.getRegistrationStatus());
        registration_master.setRegistrationType(registrationBean.getRegistrationType());
        registration_master.setUserId(registrationBean.getUserId());
        return registrationRepository.save(registration_master);
    }

   /* @GetMapping("/logincredentials")
    public */


    public static void main(String[] args) {
        SpringApplication.run(AzureApplication.class, args);
    }



    private static String uniqueId() {
        Long timeId = new Long(System.nanoTime());
        String timeIdString = timeId.toString();
        Double randomId = new Double(Math.floor(Math.random() * 1000D));
        String randomIdString = String.valueOf(randomId.intValue());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(randomIdString);
        stringBuffer.append(timeIdString);
        String generatedId = null;
        try {
            generatedId = stringBuffer.toString();
            if (generatedId.length() >= 19) {
                generatedId = generatedId.substring(0, 18);
            }
        } catch (Exception exception) {

        }
        return generatedId;
    }

    //EMAIL

   /* public static void main( String[] args )
    {
        String connectionString = "endpoint=https://codefest-communication-service.communication.azure.com/;accesskey=uNhIrqaD/ukokOcZBhuTNezDYey8vpa+N8PvXX7qhhH5pZVX1PUwJIxwH32UOLoXhmuAjayfhIndgMmOIZuVWw==";


        EmailClient emailClient = new EmailClientBuilder().connectionString(connectionString).buildClient();

        String subject = "Send email quick start - java";

        EmailContent emailContent = new EmailContent(subject)
                .setPlainText("This is plain mail send test body \n Best Wishes!!")
                .setHtml("<html><body><h1>Quick send email test</h1><br/><h4>Communication email as a service mail send app working properly</h4><p>Happy Learning!!</p></body></html>");

        String sender = "StartYoungUK@69590e86-4355-459f-88ee-475db743e7bc.azurecomm.net";
        List<EmailAddress> emailAddress = new ArrayList<EmailAddress>() {
            {
                add(new EmailAddress("deeven1109@gmail.com").setDisplayName("Deeven Successfully"));
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
                return;
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
    }*/

}
