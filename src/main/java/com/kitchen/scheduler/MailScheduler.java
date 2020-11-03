package com.kitchen.scheduler;

import com.kitchen.configuration.AdminConfig;
import com.kitchen.domain.Mail;
import com.kitchen.service.MailCreatorService;
import org.jetbrains.annotations.Async;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailCreatorService mailCreatorService;

    @Autowired
    private AdminConfig adminConfig;

    private void send (MimeMessagePreparator mimeMessagePreparator) {
        LOGGER.info("Starting email preparation...");
        try {
            javaMailSender.send(mimeMessagePreparator);
            LOGGER.info("Email send successful");
        } catch (MailException e) {
            LOGGER.error("Failed to process email sending! ", e.getMessage(), e); }
    }

    private MimeMessagePreparator createMimeMessageDailyExpiryDateMail(final Mail mail) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getMailTo());
            messageHelper.setSubject(mail.getSubject());
            messageHelper.setText(mailCreatorService.buildDailyExpiryDateMail(mail.getMessage()),true);
        };
    }

    @Scheduled(cron = "0 0 8 * * *")
    public void sendDailyExpiryDateMail() {
        Mail mail = new Mail(adminConfig.getEmail(),"Approaching the end of expiry date", "The expiry date of your products ends today!");
        MimeMessagePreparator mimeMessageDailyExpiryDateMail = createMimeMessageDailyExpiryDateMail(mail);
        send(mimeMessageDailyExpiryDateMail);
        mailCreatorService.deleteProductNamesExpiryDateToday();
    }
}
