package com.ktech.service;

import java.io.File;

import com.ktech.dto.EmailRequest;

public interface EmailService {

	public void emailSending(EmailRequest request);

	public void sendEmailWithAttachment(String to, String subject, String text, File tempFile);
}
