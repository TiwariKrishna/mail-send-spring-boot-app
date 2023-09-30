package com.ktech.rest;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ktech.dto.EmailRequest;
import com.ktech.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;

	@PostMapping("/send")
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
		try {
			emailService.emailSending(emailRequest);
			return ResponseEntity.ok("Email sent successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send email: " + e.getMessage());
		}
	}

	@PostMapping("/send-email")
	public ResponseEntity<String> sendEmailWithAttachment(@RequestBody EmailRequest emailRequest,
			MultipartFile attachment) throws MessagingException {
		try {
			// Save the attachment to a temporary file
			File tempFile = File.createTempFile("temp", ".docx");
			attachment.transferTo(tempFile);

			// Send the email with the attachment
//			emailService.sendEmailWithAttachment(emailRequest.getTo(), emailRequest.getSubject(),
//					emailRequest.getBody(), tempFile);

			emailService.sendEmailWithAttachment(emailRequest.getTo(), emailRequest.getSubject(),
					emailRequest.getBody(), tempFile);

			// Clean up the temporary file
			tempFile.delete();

			return ResponseEntity.ok("Email sent with attachment successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send email: " + e.getMessage());
		}
	}
}
