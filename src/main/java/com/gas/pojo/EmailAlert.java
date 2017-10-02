/*
 * To change this license header;  String choose License Headers in Project Properties.
 * To change this template file;  String choose Tools | Templates
 * and open the template in the editor.
 */
package com.gas.pojo;

/**
 *
 * @author akhtar
 */
public class EmailAlert 
{
    String emailId ; 
    String mailReceiver ; 
    String emailMessage ; 
    String emailSubject ; 
    String emailPreority ; 
    String emailStatus ; 
    String emailMode ; 
    String emailPath ;  
    String emailAttachmentType ;  
    byte[] emailAttachment;

    public EmailAlert(String emailId, String mailReceiver, String emailMessage, String emailSubject, String emailPreority, String emailStatus, String emailMode, String emailPath, String emailAttachmentType, byte[] emailAttachment) {
        this.emailId = emailId;
        this.mailReceiver = mailReceiver;
        this.emailMessage = emailMessage;
        this.emailSubject = emailSubject;
        this.emailPreority = emailPreority;
        this.emailStatus = emailStatus;
        this.emailMode = emailMode;
        this.emailPath = emailPath;
        this.emailAttachmentType = emailAttachmentType;
        this.emailAttachment = emailAttachment;
    }

    
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setMailReceiver(String mailReceiver) {
        this.mailReceiver = mailReceiver;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public void setEmailPreority(String emailPreority) {
        this.emailPreority = emailPreority;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public void setEmailMode(String emailMode) {
        this.emailMode = emailMode;
    }

    public void setEmailPath(String emailPath) {
        this.emailPath = emailPath;
    }

    public void setEmailAttachmentType(String emailAttachmentType) {
        this.emailAttachmentType = emailAttachmentType;
    }

    public void setEmailAttachment(byte[] emailAttachment) {
        this.emailAttachment = emailAttachment;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getMailReceiver() {
        return mailReceiver;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public String getEmailPreority() {
        return emailPreority;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public String getEmailMode() {
        return emailMode;
    }

    public String getEmailPath() {
        return emailPath;
    }

    public String getEmailAttachmentType() {
        return emailAttachmentType;
    }

    public byte[] getEmailAttachment() {
        return emailAttachment;
    }
    
    
    
    
    
    
    
}
