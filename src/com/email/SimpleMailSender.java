package com.email;

import java.util.Date;    
import java.util.Properties;   
import javax.mail.Address;    
import javax.mail.BodyPart;    
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
* ¼򵦓ʼ��µœʼ�Ά�
http://www.bt285.cn BTЂ՘
*/    
public class SimpleMailSender  {    
/**   
  * Ӕτ±¾¸򊽷¢̍Ԋ¼�  * @param mailInfo ´�œʼ�¢   
  */    
    public boolean sendTextMail(MailSenderInfo mailInfo) {    
      // Ɛ¶ЊǷ򑩒ªʭ·ވЖ¤    
      MyAuthenticator authenticator = null;    
      Properties pro = mailInfo.getProperties();   
      if (mailInfo.isValidate()) {    
      // ɧ¹�ʭ·ވЖ¤£¬ղ´´½¨һ¸�쒩֤Ƿ    
        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());    
      }   
      // ¸�¼��΃݂쒩֤Ƿ¹¹լһ¸�Γʼ�sion    
      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);    
      try {    
      // ¸�ssion´´½¨һ¸��   
      Message mailMessage = new MimeMessage(sendMailSession);    
      // ´´½¨Ԋ¼�ߵٖ·    
      Address from = new InternetAddress(mailInfo.getFromAddress());    
      // ʨ׃Ԋ¼�ķ¢̍֟    
      mailMessage.setFrom(from);    
      // ´´½¨Ԋ¼�֕ߵٖ·£¬²¢ʨ׃µ½Ԋ¼�Π   
      Address to = new InternetAddress(mailInfo.getToAddress());    
      mailMessage.setRecipient(Message.RecipientType.TO,to);    
      // ʨ׃Ԋ¼�Ŗ�   
      mailMessage.setSubject(mailInfo.getSubject());    
      // ʨ׃Ԋ¼�¢̍µŊ±¼➠  
      mailMessage.setSentDate(new Date());    
      // ʨ׃Ԋ¼�Ŗ�ۈ۠   
      String mailContent = mailInfo.getContent();    
      mailMessage.setText(mailContent);    
      // ·¢̍Ԋ¼�
      Transport.send(mailMessage);   
      return true;    
      } catch (MessagingException ex) {    
          ex.printStackTrace();    
      }    
      return false;    
    }    
       
    /**   
      * ӔHTML¸򊽷¢̍Ԋ¼�      * @param mailInfo ´�œʼ�  
      */    
    public static boolean sendHtmlMail(MailSenderInfo mailInfo){    
      // Ɛ¶ЊǷ򑩒ªʭ·ވЖ¤    
      MyAuthenticator authenticator = null;   
      Properties pro = mailInfo.getProperties();   
      //ɧ¹�ʭ·ވЖ¤£¬ղ´´½¨һ¸�쒩֤Ƿ     
      if (mailInfo.isValidate()) {    
        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());   
      }    
      // ¸�¼��΃݂쒩֤Ƿ¹¹լһ¸�Γʼ�sion    
      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);    
      try {    
      // ¸�ssion´´½¨һ¸��   
      Message mailMessage = new MimeMessage(sendMailSession);    
      // ´´½¨Ԋ¼�ߵٖ·    
      Address from = new InternetAddress(mailInfo.getFromAddress());    
      // ʨ׃Ԋ¼�ķ¢̍֟    
      mailMessage.setFrom(from);    
      // ´´½¨Ԋ¼�֕ߵٖ·£¬²¢ʨ׃µ½Ԋ¼�Π   
      Address to = new InternetAddress(mailInfo.getToAddress());    
      // Message.RecipientType.TO˴є±½Ԋ֕ߵŀᑍΪTO    
      mailMessage.setRecipient(Message.RecipientType.TO,to);    
      // ʨ׃Ԋ¼�Ŗ�   
      mailMessage.setSubject(mailInfo.getSubject());    
      // ʨ׃Ԋ¼�¢̍µŊ±¼➠  
      mailMessage.setSentDate(new Date());    
      // MiniMultipart`ˇһ¸��¬°�eBodyPart`эµĶՏ񞞠 
      Multipart mainPart = new MimeMultipart();    
      // ´´½¨һ¸�¬HTMLŚɝµÍimeBodyPart    
      BodyPart html = new MimeBodyPart();    
      // ʨ׃HTMLŚɝ    
      html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");    
      mainPart.addBodyPart(html);    
      // ½«MiniMultipart¶Տ􊩖ĎªԊ¼�   
      mailMessage.setContent(mainPart);    
      // ·¢̍Ԋ¼�
      Transport.send(mailMessage);    
      return true;    
      } catch (MessagingException ex) {    
          ex.printStackTrace();    
      }    
      return false;    
    }    
}   
