package com.masspick.peak.guest.common.email;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

import java.util.ArrayList;
import java.util.List;

/**
 * MailUtil
 */
public final class MailUtil {

    /**
     * @param args
     */
    public static void main(String[] args) {
//       send("382955894@qq.com","E:\\home\\wheel\\contract\\1.doc");
//        send("382955894@qq.com","E:\\home\\wheel\\contract\\1.doc", "E:\\home\\wheel\\contract\\2.doc");
    }


    /**
     * @param receiveUrl
     * @param attUrl
     * @return Boolean
     */
    public static Boolean send(String receiveUrl, String... attUrl) {

        List<EmailAttachment> attachmentList = new ArrayList<>();
        try {

            if (attUrl.length == 1) {
                EmailAttachment attachment = new EmailAttachment();
                attachment.setPath(attUrl[0]);
                attachment.setDisposition(EmailAttachment.ATTACHMENT);
                attachment.setDescription("贷款合同文件.doc");
                attachment.setName("贷款合同文件.doc");
                attachmentList.add(attachment);
            }

            if (attUrl.length == 2) {
                EmailAttachment etpAuthAttachment = new EmailAttachment();
                etpAuthAttachment.setPath(attUrl[0]);
                etpAuthAttachment.setDisposition(EmailAttachment.ATTACHMENT);
                etpAuthAttachment.setDescription("企业信息采集授权书.doc");
                etpAuthAttachment.setName("企业信息采集授权书.doc");
                attachmentList.add(etpAuthAttachment);

                EmailAttachment creditAttachment = new EmailAttachment();
                creditAttachment.setPath(attUrl[1]);
                creditAttachment.setDisposition(EmailAttachment.ATTACHMENT);
                creditAttachment.setDescription("个人征信查询授权书.doc");
                creditAttachment.setName("个人征信查询授权书.doc");
                attachmentList.add(creditAttachment);
            }

            // Create the email message
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.163.com");

            email.setAuthentication("bojindaiyun2018@163.com", "bjddsj2017");
            email.addTo(receiveUrl, "授权方");
            email.setFrom("bojindaiyun2018@163.com", "方舟");
            email.setSubject("合同");
            email.setMsg("请仔细查看合同文件");
            email.setSslSmtpPort("25");
            email.setSSLCheckServerIdentity(false);
            // add the attachment
            for (EmailAttachment emailAttachment : attachmentList) {
                email.attach(emailAttachment);
            }
            email.send();

        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
