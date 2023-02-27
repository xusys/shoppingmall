//package com.demo.servlet;
//
//import com.sun.mail.util.MailSSLSocketFactory;
//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import java.util.Properties;
//
//public class emailServlet {
//    public static void main(String[] args) throws Exception{
//        Properties properties = new Properties();
//        properties.setProperty("mail.host","smtp.qq.com");       //设置QQ邮箱服务器
//        properties.setProperty("mail.transport.protocol","smtp");       //邮件发送协议
//        properties.setProperty("mail.smtp.auth","true");       //需要验证用户名密码
//        //QQ邮箱还需要设置SSL加密，加上以下代码即可
//        MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
//        mailSSLSocketFactory.setTrustAllHosts(true);
//        properties.put("mail.smtp.ssl.enable","true");
//        properties.put("mail.smtp.ssl.socketFactory",mailSSLSocketFactory);
//        //使用JavaMail发送邮件的5个步骤
//        //1.创建定义整个应用程序所需的环境信息的Session对象
//        Session session=Session.getDefaultInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("1654383402@qq.com","CJ123!@#");
//            }
//        });
//        session.setDebug(true);       //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
//        //2.通过session得到transport对象
//        Transport transport = session.getTransport();
//        //3.使用邮箱的用户名和授权码连上邮件服务器
//        transport.connect("smtp.qq.com","1654383402@qq.com","CJ123!@#");
//        //4.创建邮件
//        MimeMessage message = new MimeMessage(session);       //需要传递session
//        message.setFrom(new InternetAddress("1654383402@qq.com"));
//        message.setRecipient(Message.RecipientType.TO,new InternetAddress("aotuma123@gmail.com"));
//        message.setSubject("什么都有的邮件");       //设置邮件标题
//        //准备邮箱数据
//        //准备图片数据
////        MimeBodyPart image = new MimeBodyPart();
////        DataHandler dh = new DataHandler(new FileDataSource("src/resources/第一天.png"));       //对图片进行数据处理
////        image.setDataHandler(dh);       //在Body中放入这个处理的图片数据
////        image.setContentID("1.png");       //给图片设置一个id，方便后面使用
//        //准备正文数据
//        MimeBodyPart text = new MimeBodyPart();
//        text.setContent("这是一个封邮件正文带图片<img src='cid:1.png'>的邮件","text/html;charset=utf-8");
//        //准备附件数据
////        MimeBodyPart file = new MimeBodyPart();
////        DataHandler ddh = new DataHandler(new FileDataSource("src/resources/1.txt"));
////        file.setDataHandler(ddh);
////        file.setFileName("1.txt");       //给附件设置一个名字，方便后面使用
//        //描述数据关系
//        MimeMultipart mimeMultipart = new MimeMultipart();
//        mimeMultipart.addBodyPart(text);
////        mimeMultipart.addBodyPart(image);
//        mimeMultipart.setSubType("related");
//        MimeBodyPart content = new MimeBodyPart();
//        content.setContent(mimeMultipart);
//        MimeMultipart mimeMultipart1 = new MimeMultipart();
////        mimeMultipart1.addBodyPart(file);
////        mimeMultipart1.addBodyPart(content);
////        mimeMultipart1.setSubType("mixed");
//        //设置到消息中，保存修改
//        message.setContent(mimeMultipart1);       //把最后编辑好的邮件放入消息当中
//        message.saveChanges();       //保存修改
//        //5.发送邮件
//        transport.sendMessage(message,message.getAllRecipients());
//        //6.关闭连接
//        transport.close();
//    }
//}
