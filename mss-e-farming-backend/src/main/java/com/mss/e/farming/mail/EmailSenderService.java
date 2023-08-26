package com.mss.e.farming.mail;

import com.mss.e.farming.config.AppConstants;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmailWithoutAttachment(String toEmail,
                                           String subjectEmail,
                                           String bodyEmail)
            throws MessagingException, UnsupportedEncodingException {

        MimeMessage mimeMailMessage = this.javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);

        mimeMessageHelper.setFrom(AppConstants.fromEmail, "MSS - E Farming");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject(subjectEmail);
        mimeMessageHelper.setText(bodyEmail, true);

        this.javaMailSender.send(mimeMailMessage);

        System.out.println("Mail send successfully.....");

    }

    public void sendEmailWithAttachment(String toEmail,
                                        String subjectEmail,
                                        String bodyEmail,
                                        String[] attachment) throws MessagingException {

        MimeMessage mimeMailMessage = this.javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);

        mimeMessageHelper.setFrom(AppConstants.fromEmail);
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject(subjectEmail);
        mimeMessageHelper.setText(bodyEmail);

        File file = new File(AppConstants.imagePath);

        mimeMessageHelper.addAttachment(file.getName(), file);

        this.javaMailSender.send(mimeMailMessage);

        System.out.println("Mail send successfully.....");

    }


}
