package org.coder.mail.impl;

import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.coder.mail.GenericMailManager;
import org.coder.mail.exception.MailServiceException;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class GenericMailManagerImpl implements GenericMailManager {
	private JavaMailSender javaMailSender;
	private String from;
	private boolean sendMail;

	public void sendAttachmentMail(List<String> to, List<String> cc, String subject, String mailBodyText,
			List<Resource> attachement) throws MessagingException, MailServiceException {
		MimeMessage message = this.javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

		helper.setFrom(this.from);
		if ((to != null) && (!to.isEmpty())) {
			for (String toAddress : to) {
				helper.addTo(toAddress);
			}
		}
		if ((cc != null) && (!cc.isEmpty())) {
			for (String ccAddress : cc) {
				helper.addCc(ccAddress);
			}
		}
		helper.setText(mailBodyText, true);
		helper.setSubject(subject);
		if ((attachement != null) && (!attachement.isEmpty())) {
			for (Resource resource : attachement) {
				try {
					helper.addAttachment(resource.getFilename(), resource.getFile());
				} catch (IOException e) {
					throw new MailServiceException(e);
				}
			}
		}
		if (this.sendMail) {
			this.javaMailSender.send(message);
		}
	}

	public void sendMail(List<String> to, List<String> cc, String subject, String mailBodyText)
			throws MailException, MessagingException, MailServiceException {
		sendAttachmentMail(to, cc, subject, mailBodyText, null);
	}

	public JavaMailSender getJavaMailSender() {
		return this.javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public boolean isSendMail() {
		return this.sendMail;
	}

	public void setSendMail(boolean sendMail) {
		this.sendMail = sendMail;
	}
}
