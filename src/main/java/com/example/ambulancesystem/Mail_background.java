package com.example.ambulancesystem;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class Mail_background {

    public static String otp;
    public static int sendOTP(String userEmail) {
        final String username = "dinerahmed05@gmail.com";
        final String password = "crzgoxdgpzgugoog";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dinerahmed05@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));

            // Generate a random 6-digit OTP
            otp = generateOTP();

            // Set the email content with the OTP
            message.setSubject(otp);
            message.setText("Your User login OTP is: " + otp);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(otp);
    }

    private static String generateOTP() {
        // Generate a random 6-digit OTP
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return Integer.toString(otp);
    }

    public static void main(String[] args) {
        String userEmail = "dinerahmed05@gmail.com";
       // sendOTP(userEmail);
    }
}