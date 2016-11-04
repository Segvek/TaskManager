/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Panas
 */
public class Sender {
    private static String myMail="appspanasenco@gmail.com";
    private static String myPass="Apps08.05.2016";
    private static String title="TaskManager";

    public static boolean send(String content,String recipient) {
        content+="\nПодверждение акаунта на сервисе Task Manager";
        try {
            Properties props = new Properties();

            props.put("mail.transport.protocol", "smtps");
            props.put("mail.smtps.host", myMail);
            props.put("mail.smtps.auth", "true");
            props.put("mail.smtp.sendpartial", "true");

            Session session = Session.getDefaultInstance(props);
            session.setDebug(false);
            Transport transport = session.getTransport();
            transport.connect("smtp.gmail.com", 465, myMail, myPass);

            MimeMessage message = new MimeMessage(session);
            message.setSubject(title);
            message.setText(content);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //ะบ
            message.setSentDate(new Date());

            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        } catch (MessagingException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

}
