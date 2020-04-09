package com.email;
import javax.mail.*; 
public class MyAuthenticator extends Authenticator{   
    String userName=null;   
    String password=null;   
        
    public MyAuthenticator(){   
    }   
    public MyAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }   
    
    public void sendEmail(String toAddress,String subject,String content)
    {
    	MailSenderInfo mailInfo = new MailSenderInfo();    
        mailInfo.setMailServerHost("smtp.163.com");    
        mailInfo.setMailServerPort("25");    
        mailInfo.setValidate(true);    
        mailInfo.setUserName("13236236212@163.com");    
        mailInfo.setPassword("zhaobai83533075");//您的邮箱密码    
        mailInfo.setFromAddress("13236236212@163.com");     
        mailInfo.setToAddress(toAddress);    
        mailInfo.setSubject(subject);    
        mailInfo.setContent(content);    
           //这个类主要来发送邮件   
        SimpleMailSender sms = new SimpleMailSender();   
            sms.sendTextMail(mailInfo);//发送文体格式    
//            sms.sendHtmlMail(mailInfo);//发送html格式   
            System.out.println("邮件已经发送");
    }
    
    public static void main(String[] args){   
        //这个类主要是设置邮件   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.163.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);    
     mailInfo.setUserName("13236236212@163.com");    
     mailInfo.setPassword("zhaobai83533075");//您的邮箱密码    
     mailInfo.setFromAddress("13236236212@163.com");    
     mailInfo.setToAddress("491808144@qq.com");    
     mailInfo.setSubject("扫货");    
     mailInfo.setContent("真是个骚货");    
        //这个类主要来发送邮件   
     SimpleMailSender sms = new SimpleMailSender();   
         sms.sendTextMail(mailInfo);//发送文体格式    
//         sms.sendHtmlMail(mailInfo);//发送html格式   
   }  
}   
