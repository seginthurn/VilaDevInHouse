package br.com.inthurn.VilaDevInHouse.service.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailServiceImpl {

    Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);


    @Autowired
    private JavaMailSender mailSender;

    @Value("${MAIL_USERNAME}")
    private String from;

    public void sendMail(String to, String subject, String text) {
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
            logger.info("E-mail de ERRO enviado para: " + to);
//            mailSender.send(mail);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMailWithAttachment(String to, String subject, String text, String pathToAttachment) {
        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(this.from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file
                    = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice", file);
            logger.info("Email enviado para: " + to + "; Arquivo em anexo: " + file.getFilename());

//            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
